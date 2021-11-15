package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

import static MultidimensionalArraysLab.P3IntersectionOfTwoMatrix.readMatrix;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }

    public static int[][] readMatrix(int rows, int cols,Scanner scanner, String splitPattern) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
    return matrix;
    }

}
