package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.DoubleFunction;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Double> studentGrades = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double avg = sum / grades.length;
            studentGrades.put(name,avg);
        }
        DecimalFormat format = new DecimalFormat("0.################");
//        for (var entry : studentGrades.entrySet()) {    // ако не се изисква закръгляне да не се използва.average().oreElse()!!!
//            double avg = Arrays.stream(entry.getValue()).average().orElse(0);
//            System.out.println(entry.getKey() + " is graduated with " + format.format(avg));
//        }
        studentGrades.forEach((k,v) -> System.out.printf("%s is graduated with %s%n",k,format.format(v)));
    }
}
