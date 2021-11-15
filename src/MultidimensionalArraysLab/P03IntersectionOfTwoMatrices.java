package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          int rows = Integer.parseInt(scanner.nextLine());
          int cols  = Integer.parseInt(scanner.nextLine());

          char[][] firstMatrix = new char[rows][cols];
          char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows ; row++) {// четене на char MATRIX;
            firstMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+","")
                    .toCharArray();
        }
        for (int row = 0; row < rows; row++) {// четене на char MATRIX;
            secondMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+","")
                    .toCharArray();
        }
        char[][] finalMatrix = new char[rows][cols];
        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                char firstSymol = firstMatrix[row][col];
                char secondSymol = secondMatrix[row][col];
                finalMatrix[row][col] = firstSymol == secondSymol ? firstSymol : '*';


            }
        }
    }
}
