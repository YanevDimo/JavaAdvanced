package MultidimensionalArraysExercises;

import java.util.*;

public class p07Crossfire {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")){
            String[] data = input.split(" ");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        for(List<Integer> integers : matrix){
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}