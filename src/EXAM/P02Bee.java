package EXAM;

import java.util.Scanner;

public class P02Bee {
    static int newRow = 0, newCol = 0, pollinateFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("B")) {
                newRow = i;
                newCol = line.indexOf("B");
            }
        }

        boolean isInField = true;
        String direction = scanner.nextLine();

        while (isInField &&!direction.equals("End")) {

            switch (direction) {
                case "up":
                    isInField = moveBee(field, -1, 0);
                    break;
                case "down":
                    isInField = moveBee(field, +1, 0);
                    break;
                case "left":
                    isInField = moveBee(field, 0, -1);
                    break;
                default:
                    isInField = moveBee(field, 0, +1);
                    break;
            }
            direction=scanner.nextLine();
        }

        if (pollinateFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinateFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinateFlowers);
        }

        System.out.println(getFieldString(field));
    }

    private static String getFieldString(char[][] field) {
        StringBuilder out = new StringBuilder();
        for (char[] row : field) {
            for (char element : row) {
                out.append(element);
            }
            out.append(System.lineSeparator());
        }

        return out.toString();
    }

    public static boolean moveBee(char[][] field, int rowAddition, int colAddition) {
        field[newRow][newCol] = '.';
        boolean isInBounds = inBounds(field, newRow + rowAddition, newCol + colAddition);
        if (isInBounds) {
            if (field[newRow + rowAddition][newCol + colAddition] == 'f') {
                pollinateFlowers += 1;
            } else if (field[newRow+ rowAddition][newCol + colAddition] == 'O') {
                field[newRow + rowAddition][newCol + colAddition] = '.';

                newRow += rowAddition;
                newCol += colAddition;
                if (field[newRow + rowAddition][newCol+ colAddition] == 'f') {
                    pollinateFlowers += 1;
                }

            }

           newRow += rowAddition;
            newCol += colAddition;
            field[newRow][newCol] = 'B';

        }
        return isInBounds;
    }

    private static boolean inBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}
