package EXAM;

import java.util.Scanner;

import static java.awt.SystemColor.text;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        int sizeSquare = Integer.parseInt(scanner.nextLine());

        char[][] matrixF = new char[sizeSquare][sizeSquare];

        int[] position = new int[2];

        for (int i = 0; i < sizeSquare; i++) {
            String line = scanner.nextLine();
            matrixF[i] = line.toCharArray();
            if (line.contains("P")) {
                position[0] = i;
                position[1] = line.indexOf("P");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    movePlayer(position[0] - 1, position[1], position, matrixF, text);
                    break;
                case "down":
                    movePlayer(position[0] + 1, position[1], position, matrixF, text);
                    break;
                case "left":
                    movePlayer(position[0], position[1] - 1, position, matrixF, text);
                    break;
                case "right":
                    movePlayer(position[0], position[1] + 1, position, matrixF, text);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(text.toString());
        printMatrix(matrixF);
    }

    private static void movePlayer(int newRow, int newCol, int[] position, char[][] matrixF, StringBuilder text) {

        if (isOutOfBounds(matrixF, newRow, newCol)) {
            if (text.length() != 0) {
                text.deleteCharAt(text.length() - 1);
            }
            return;
        }
        if (matrixF[newRow][newCol] != '-') {
            text.append(matrixF[newRow][newCol]);
        }
        matrixF[position[0]][position[1]] = '-';
        matrixF[newRow][newCol] = 'P';

        position[0] = newRow;
        position[1] = newCol;
    }

    private static boolean isOutOfBounds(char[][] matrixF, int row, int col) {
        return row < 0 || row >= matrixF.length || col < 0 || col >= matrixF[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        //printMatrix
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }
}
