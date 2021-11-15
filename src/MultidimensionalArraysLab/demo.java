package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];

        readMatrix(scanner, rows, cols);
        System.out.println();
    }

    // четене на матрицата от конзолата
    private static void readMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
    }

    // дали не е outOfBound
    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row < matrix.length && row >= 0
                && col < matrix[row].length && col >= 0;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()//четене на масива от конзолата
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}

