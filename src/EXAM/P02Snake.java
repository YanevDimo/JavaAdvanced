package EXAM;

import java.net.PortUnreachableException;
import java.util.Map;
import java.util.Scanner;

public class P02Snake {
    public static int food = 0;
    public static int rowSnake = 0, colSnake = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int[] firstBurrowIndexes = {-1, -1};
        int[] secondBurrowIndexes = {-1, -1};

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                rowSnake = row;
                colSnake = line.indexOf("S");
            }
            if (line.contains("B")) {
                fillBurrowIndex(firstBurrowIndexes, secondBurrowIndexes, row, line);

            }
            matrix[row] = line.toCharArray();
        }
//        int food = 0;
        while (food < 10) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                if (isOutOfBounds(rowSnake - 1, colSnake, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake - 1, colSnake, matrix)) {
                        rowSnake--;
                    }
                }
            } else if (command.equals("down")) {
                if (isOutOfBounds(rowSnake + 1, colSnake, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake + 1, colSnake, matrix)) {
                        rowSnake++;
                    }
                }
            } else if (command.equals("left")) {
                if (isOutOfBounds(rowSnake, colSnake - 1, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake, colSnake - 1, matrix)) {
                        colSnake--;
                    }
                }
            } else if (command.equals("right")) {
                if (isOutOfBounds(rowSnake, colSnake + 1, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake, rowSnake, colSnake + 1, matrix)) {
                        colSnake++;
                    }
                }
            }
        }
        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            matrix[rowSnake][colSnake] = '.';
            System.out.println("Game over");
        }
        System.out.println("Food eaten: " + food);
        printMatrix(matrix);
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void fillBurrowIndex(int[] firstBurrowIndexes, int[] secondBurrowIndexes, int row, String line) {
        if (firstBurrowIndexes[0] == -1) {
            firstBurrowIndexes[0] = row;
            firstBurrowIndexes[1] = line.indexOf("B");
        } else {
            secondBurrowIndexes[0] = row;
            secondBurrowIndexes[1] = line.indexOf("B");
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public static boolean moveSnake(int oldRow, int oldCol, int newRow, int newCol, char[][] matrix) {
        if (matrix[newRow][newCol] == '-') {
            matrix[newRow][newCol] = 'S';
        } else if (matrix[newRow][newCol] == '*') {
            matrix[newRow][newCol] = 'S';
            food++;
            //which barrow is the snake at
            //where is the other one
        } else if (matrix[newRow][newCol] == 'B') {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B' && (row != newRow || col != newCol)) {
                        matrix[row][col] = 'S';
                        matrix[oldRow][oldCol] = '.';
                        rowSnake = row;
                        colSnake = col;
                        return true;
                    }
                }
            }
        }
        matrix[oldRow][oldCol] = '.';
        return false;
    }
}
