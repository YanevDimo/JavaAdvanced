package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        fillMatrix(scanner, matrix, size);

        int sumPrimary = getSumOfPrimaryDiagonal(matrix, size);
        int sumSecondary = getSumOfSecondaryDiagonal(matrix, size);

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix, int size) {
        //пълнене на втористепнния диагонал
        //row + col == size - 1; или col == size - row -1;
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col == size - row - 1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    //сумиране на елементи(по диагонала) реда и колоната са равни!
    private static int getSumOfPrimaryDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    // пълнене на матрицата!
    private static void fillMatrix(Scanner scanner, int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
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
