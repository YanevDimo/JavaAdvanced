package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

         List<Integer> numbers;
        numbers = Arrays.stream( scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer>evenNum = numbers.stream()
                .filter(e ->e % 2 == 0)
                .collect(Collectors.toList());

        String firstOutput = evenNum
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(firstOutput);

        String secondOutput = evenNum
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(secondOutput);

    }
}
