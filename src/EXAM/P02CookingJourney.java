package EXAM;

import java.util.Scanner;

public class P02CookingJourney {

    //извеждане на променливите в статични за да се виждат в методите !!!
    public static int ownerRowPosition, ownerColPosition,clientRowPosition,clientColPosition;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

         //Find position and fill the matrix
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                ownerRowPosition = row;
                ownerColPosition = line.indexOf("S");
            }
            if (line.contains("P")){
                clientRowPosition = row;
                clientColPosition = line.indexOf("P");
            }
            matrix[row] = line.toCharArray();

            int money = 0;


//            while (money < 50){
//                String command = scanner.nextLine();
//
//                move(ownerRowPosition,ownerColPosition,newRow,intNewCol,matrix);
//
//            }


            fillMatrix(matrix);

        }
    }

    private static void move(int ownerRowPosition, int ownerColPosition, char[][] matrix) {
        matrix[ownerRowPosition][ownerColPosition] = '-';// там където е било става празна клетка -> '-'
        matrix[ownerRowPosition + 1][ownerColPosition] = 'S';//позицията на която се е преместило с 1 -> 'S'
    }



    private static void fillMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
