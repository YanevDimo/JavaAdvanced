package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);//четене на двумерна матрица от конзолата
        int[][] secondMatrix = readMatrix(scanner);//четене на двумерна матрица от конзолата

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
               int[]firstArr = firstMatrix[row];
               int[]secondArr = secondMatrix[row];
               areNotEqual = firstArr.length != secondArr.length;
                if (!areNotEqual) {
                    for (int col = 0; col < firstArr.length; col++) {
                        if (firstArr[col] != secondArr[col]){
                            areNotEqual = true;
                            break;
                        }
                    }
                }
                if (areNotEqual) {
                    break;
                }
            }
        }


        String output = areNotEqual ? "not equal" : "equal";// тернарни оператори ,?, ,:,
        System.out.println(output);
//        printMatrix(matrix);

    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {//отпечатване на матрица
            int[] arr = matrix[i];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
            //другия начин е
//            for (int row = 0; row < matrix.length; row++) {
//                for (int col = 0; col < matrix[row]; col++) {
//                    System.out.println(matrix[row][col] + " ");
//                }
//                System.out.println();
//            }
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()//четене на масива от конзолата
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
