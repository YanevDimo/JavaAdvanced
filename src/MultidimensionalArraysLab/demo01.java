package MultidimensionalArraysLab;

import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = input.split(", ")[1];
        int rows = Integer.parseInt(input.split(", ")[0]);

        int[][] matrix = new int[rows][];
        fillMatrixA(matrix, rows, pattern);
//        fillMatrixB(rows, pattern);
    }

    private static void fillMatrixA(int[][] matrix, int num, String pattern) {
        int startIndex = 1;
        for (int row = startIndex; row < num; row++) {
            for (int col = 0; col < num; col++) {
                matrix = new int[num][num];
            }
        }
    }

}
