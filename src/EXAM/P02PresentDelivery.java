package EXAM;

import java.util.Scanner;

public class P02PresentDelivery {
    public static int presents;
    public static int sanaRow;
    public static int sanaCol;
    public static int niceKids = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        //fill the matrix and find position;
        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();

            if (line.contains("S")) {
                sanaRow = r;
                sanaCol = line.indexOf("S");
            }
            for (char e : line.toCharArray()) {// фор за да се провери дали няма пове4е о 1 срещане
                if (line.contains("V")) {
                    niceKids++;
                }
            }

        }
        int allNiceKids = niceKids;
        String direction = scanner.nextLine();


        while (!direction.equals("Christmas morning")) {


            if (direction.equals("up")) {
                ensureMoveSanta(matrix, sanaRow - 1, sanaCol);
            } else if (direction.equals("down")) {
                ensureMoveSanta(matrix, sanaRow + 1, sanaCol);
            } else if (direction.equals("left")) {
                ensureMoveSanta(matrix, sanaRow, sanaCol - 1);
            } else {
                ensureMoveSanta(matrix, sanaRow, sanaCol + 1);
            }
            if (presents <= 0) {
                break;
            }


            direction = scanner.nextLine();
        }
        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);

        if (niceKids == 0) {
            System.out.println("Good job, Santa!" + allNiceKids + "happy nice kid/s.");
        } else {
            System.out.println("No presents for " + niceKids + "nice kid/s.");
        }
    }

    private static void ensureMoveSanta(char[][] matrix, int newRow, int newCol) {

        if (isOutOfBounds(matrix, newRow, newCol)) {
//            presents = 0;

        }
        char nextStep = matrix[newRow][newCol];
        //niceKid
        if (nextStep == 'V') {
            presents--;
            niceKids--;
            //menaceHere
        } else if (nextStep == 'c') {
            givePresents(matrix, newRow, newCol);

        }

        matrix[sanaRow][sanaCol] = '-';  //там където е бил става празна клетка
        matrix[newRow][newCol] = 'S';//следващите на които отива става равни на 'C'
        sanaRow = newRow;//ПРОМЯНА НА ПОЗИЦИЯТА
        sanaCol = newCol;//ПРОМЯНА НА ПОЗИЦИЯТА


    }


    private static void givesPresents(char[][] matrix, int r, int c) {
        givePresents(matrix, r - 1, c);
        givePresents(matrix, r + 1, c);
        givePresents(matrix, r, c - 1);
        givePresents(matrix, r, c + 1);
    }

    private static void givePresents(char[][] matrix, int row, int col) {
        char nextCell = matrix[row][col];
        if (nextCell == 'X' || nextCell == 'V') {
            if (nextCell == 'V') {
                niceKids--;
            }
            presents--;
            matrix[row - 1][col] = '-';
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, long col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
