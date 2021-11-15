package SetAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lengths = scanner.nextLine().split("\\s+");
        int firstLength = Integer.parseInt(lengths[0]);
        int secondLength = Integer.parseInt(lengths[1]);

        Set<Integer> first = new LinkedHashSet<>(firstLength);
        Set<Integer> second = new LinkedHashSet<>(secondLength);

        for (int i = 0; i < firstLength; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            first.add(num);
        }
        for (int i = 0; i < secondLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            second.add(number);
        }
        first.retainAll(second);
        // ratainAll -> Е ФУНКЦИОНАЛНОТ КОЯТО ПРЕМАХВА ЕЛЕМЕНТИ КОИТО НЕ СЕ ДУБЛИРАТ(или оставя само дублиращите се)

        for (Integer number : first) {
            System.out.print(number + " ");

        }
    }
}