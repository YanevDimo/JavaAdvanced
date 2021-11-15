package SetsAndMapsAdvancedLab;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> valuesWIthOccurrences = new LinkedHashMap<>();

        for (double value : values) {
            if (!valuesWIthOccurrences.containsKey(value)) {
              valuesWIthOccurrences.put(value,1);
            } else {
                valuesWIthOccurrences.put(value,valuesWIthOccurrences.get(value) + 1);
            }
        }
        for (Double key : valuesWIthOccurrences.keySet()) {
            System.out.println(String.format("%.1f -> %d",key,valuesWIthOccurrences.get(key)));
        }
    }
}
