package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P3CountUppercaseWords {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          String[] text = scanner.nextLine().split("\\s+");

//        Predicate<String>predicate = str ->Character.isUpperCase(str.charAt(0));
//       List<String> upperCase = Arrays.stream(text)
//                .filter(predicate)
//                .collect(Collectors.joining());

//        System.out.println(upperCase.size());
//        System.out.println(String.join("\n",upperCase));
    }
}
