package SetsAndMapsAdvancedLab;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOStudens = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double[]> grades = new TreeMap<>();

        for (int i = 0; i < numOStudens; i++) {
            String name = scanner.nextLine();
            String[] points = scanner.nextLine().split("\\s+");
            Double[] scores = new Double[points.length];
            for (int j = 0; j < points.length; j++) {
                points[j] = String.valueOf(Double.parseDouble(points[j]));
            }
            grades.put(name, scores);
        }

    }
}
