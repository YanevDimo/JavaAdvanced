package EXAM;

import java.util.Scanner;

public class P02MauseAndChees {

    static int startRow = 0;
    static int startCol = 0;
    static int cheese = 0;
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, matrix);

        boolean mouseGoesOut = false;
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    mouseGoesOut = move(matrix, startRow - 1, startCol, command);
                    break;
                case "down":
                    mouseGoesOut = move(matrix, startRow + 1, startCol, command);
                    break;
                case "left":
                    mouseGoesOut = move(matrix, startRow, startCol - 1, command);
                    break;
                case "right":
                    mouseGoesOut = move(matrix, startRow, startCol + 1, command);

                    break;
            }
            if (mouseGoesOut) {
                break;
            }


            command = scanner.nextLine();

        }
        if (mouseGoesOut) {
            System.out.println("Where is the mouse?");
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }

        printMatrix(matrix);

    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("M")) {
                startRow = i;
                startCol = input.indexOf("M");
            }
        }
    }
    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
    private static boolean move(char[][] matrix, int newRow, int newCol, String command) {
        matrix[startRow][startCol] = '-';
        if (indexOutOfBounds(matrix, newRow, newCol)) {
            if (matrix[newRow][newCol] == 'c') {
                cheese++;
            } else if (matrix[newRow][newCol] == 'B') {
                matrix[newRow][newCol] = '-';
                switch (command) {
                    case "up":
                        newRow = newRow - 1;
                        break;

                    case "down":
                        newRow = newRow + 1;
                        break;

                    case "left":
                        newCol = newCol - 1;
                        break;

                    case "right":
                        newCol = newCol + 1;
                        break;
                }
                if (matrix[newRow][newCol] == 'c') {
                    cheese++;
                }
            }
            matrix[newRow][newCol] = 'M';
            startRow = newRow;
            startCol = newCol;

            return false;
        }
        startRow = newRow;
        startCol = newCol;
        return true;
    }
    private static boolean indexOutOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }
}
