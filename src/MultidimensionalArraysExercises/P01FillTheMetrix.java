package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMetrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int size = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillPatternA(matrix,size);
        } else if (pattern.equals("B")) {
            fillPatternB(matrix,size);
        }
        printMatrix(matrix,size,size);

    }
// пълнене на матрицата от последния до първият ред
    private static void fillPatternB(int[][] matrix, int size) {
        int startNumber = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }
// пълнене на матрицата от първият до последният ред
    private static void fillPatternA(int[][] matrix, int size) {
        int startNum = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startNum;
                startNum++;
            }
        }
    }

    //print Matrix
    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
