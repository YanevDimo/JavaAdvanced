package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimension = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int columns = dimension[1];

        int[][] matrix = new int[rows][columns];//четене на матрица с 2 цикъла
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                int num = Integer.parseInt(tokens[i]);
                matrix[row][i] = num;
            }
        }

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<int[]> positions = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    int[] indexes = new int[]{row, col};

                    positions.add(indexes);
                }
            }
        }
        if (positions.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] position : positions) {
                System.out.println(position[0] + " " + position[1]);
            }
        }
    }
}
