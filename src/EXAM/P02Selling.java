package EXAM;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02Selling {

    public static int startRow = 0;
    public static int startCol = 0;
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
            List<int[]> pilars = new ArrayList<>();
            findPilar(matrix,pilars);
            if (pilars.size() == 2) {
                int[]pilar1 = pilars.get(0);
                int[]pilar2 = pilars.get(1);
                String command = scanner.nextLine();
//            matrix[row] = scanner.nextLine().toCharArray();
                move(command, startRow, startCol);
                while (isOutOfBounds(startRow, startCol, matrix) || money >= 50) {


                }

            }


        }
        printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public static void findPilar(char[][] matrix, List<int[]> pilars) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'O') {
                    int[] pilar = {row, col};
                    pilars.add(pilar);

                }
            }
        }
    }

    private static boolean isOutOfBounds(int r, int c, char[][] matrix) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void move(String command, int startRow, int startCol) {
        switch (command) {
            case "up":
                startRow--;
                break;
            case "down":
                startRow++;
                break;
            case "right":
                startCol++;
                break;
            case "left":
                startCol--;
                break;
        }
    }
}
