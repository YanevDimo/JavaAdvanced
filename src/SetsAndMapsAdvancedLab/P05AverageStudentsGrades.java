package SetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrade = new TreeMap<>();

        while (students-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsGrade.putIfAbsent(studentName, new ArrayList<>());
            studentsGrade.get(studentName).add(grade);

        }
       studentsGrade.forEach((key, value) -> {
           double sum = 0;
           for (int i = 0; i < value.size(); i++) {
               sum += value.get(i);
           }
           double avg = sum / value.size();
           System.out.print(key + " -> ");
           value.forEach(e -> System.out.printf("%.2f", e));
           System.out.printf("(avg: %.2f)%n", avg);
       });
    }

}

