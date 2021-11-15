package ExamPreparationJavaAdvanced;

import java.util.Scanner;

public class P02FormulaOne {

    static int startRow, startCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        //fillMatrix
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        //findPosition
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                startRow = row;
                startCol = line.indexOf("P");
            }
        }
        boolean hasWon = false;
        for (int command = 0; command < commandsCount; command++) {
            String direction = scanner.nextLine();
            int newRow = 0;
            int newCol = 0;
            switch (direction) {
                case "up":
                    break;
                case "down":
                    break;
                case "left":
                    break;
                case "right":
                    break;
            }


        }


        printMatrix(matrix);
    }

    private static boolean isOutOfBounds(int startRow, int startCol, char[][] matrix) {
        return startRow < 0 || startRow >= matrix.length || startCol < 0 || startCol >= matrix[startRow].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
