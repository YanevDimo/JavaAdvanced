package EXAM;

import java.util.Scanner;

public class P02ReVolt {

    //извеждане на променливите в статични за да се виждат в методите !!!
    public static int playerRow;
    public static int playerCol;
    public static int finishRow;
    public static int finishCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandCount = Integer.parseInt(scanner.nextLine());

        //fillMatrix
        char[][] matrix = new char[n][n];

        //find Position Of Player and fill Matrix
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("f")) {
                playerRow = i;
                playerCol = line.indexOf("f");
            }
            if (line.contains("F")) {
                finishRow = i;
                finishCol = line.indexOf("F");
            }
            matrix[i] = line.toCharArray();

            boolean hasWon = false;

            while (commandCount-- > 0 && !hasWon) {


                String command = scanner.nextLine();
                switch (command) {
                    case "up":
                        moveUp(matrix);
                        break;
                    case "down":
                        moveDown(matrix);
                        break;
                    case "left":
                        moveLeft(matrix);
                        break;
                    case "right":
                        moveRight(matrix);
                        break;
                }
                // ако hasWon стане равно на финиш кординатите се сетва на true И цикълът приклучва
                hasWon = playerRow == finishRow && playerCol == finishCol;
            }
            if (hasWon) {
                System.out.println("Player won!");
            } else {
                System.out.println("Player lost!");
            }
        }

        //printMatrix
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.println(matrix[r][c]);
            }
            System.out.println();
        }
//        System.out.println(playerRow + " " + playerCol); // проверка къде се намира играча ! //
    }

    private static void moveLeft(char[][] matrix) {
        int prevCol = playerCol;
        if (playerCol - 1 < 0) {
            playerCol = matrix.length;
        }
        if (matrix[playerRow][playerCol - 1] != 'T') {
            if (playerCol == matrix.length) {
                playerCol = 0;
            }
            matrix[prevCol][playerCol] = '-';
            playerRow--;
            if (matrix[playerRow][playerCol] != 'B') {
                playerRow--;
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveUp(char[][] matrix) {
        int prevRow = playerRow;
        if (playerRow - 1 < 0) {
            playerRow = matrix.length;
        }
        if (matrix[playerRow - 1][playerCol] != 'T') {
            if (playerRow == matrix.length) {
                prevRow = 0;
            }
            matrix[prevRow][playerCol] = '-';
            playerRow--;
            if (matrix[playerRow][playerCol] != 'B') {
                playerRow--;
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerRow = prevRow;
        }
    }

    private static void moveRight(char[][] matrix) {
        int prevCol = playerCol;
        if (playerCol + 1 == matrix.length) {
            playerCol = -1;
        }
        if (matrix[playerRow][playerCol + 1] != 'T') {
            if (playerCol == -1) {
                prevCol = matrix.length - 1;
            }
            matrix[prevCol][playerCol] = '-';
            playerCol++;
            if (matrix[playerRow][playerCol] != 'B') {
                playerCol++;
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveDown(char[][] matrix) {
        int prevRow = playerRow;
        if (playerRow + 1 == matrix.length) {
            playerRow = -1;
        }
        if (matrix[playerRow + 1][playerCol] != 'T') {
            if (playerRow == -1) {
                prevRow = matrix.length - 1;
            }
            matrix[prevRow][playerCol] = '-';
            playerRow++;
            if (matrix[playerRow][playerCol] != 'B') {
                playerRow++;
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerRow = prevRow;
        }
    }
}
