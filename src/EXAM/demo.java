package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class demo {
    private static int startRow,startCol;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> mapName = new HashMap<>();

        //Read Stack with API
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        // READ QUEUE WITH API
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //печатане на останалото съдържание на опшката
        System.out.println(queue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        //печатане на останалото съдържание stack
        System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        //отпечатване на МАПА
        mapName.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        //отпечатване на МАПА само елементите със стойности
        mapName.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf(" # %s --> %d%n", key, value);
            }});
        // MATRIX!!!
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }

            int size = Integer.parseInt(scanner.nextLine());
            char[][] matrix = new char[size][size];
            // fillMatrix
            for (int i = 0; i < size; i++) {
                matrix[i] = scanner.nextLine().toCharArray();
            }
        }
    }

    // форматиране на deque
    private static String formatArrayDeck(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";//отпечатва "none"
        }
        return deque.stream()//или връща списъка в Дека разделено с запетая и интервал!!!
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    // проверка дали е в границите на матрицата
    private static boolean isOutOfBounds(int r, int c, char[][] matrix) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return !isOutOfBounds(row, col, matrix);
    }

    //проверка за останали елементи в стека и опашката!
    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    //printMatrix
    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
