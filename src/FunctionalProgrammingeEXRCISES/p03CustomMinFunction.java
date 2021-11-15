package FunctionalProgrammingeEXRCISES;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class p03CustomMinFunction {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"1 4 3 2 1 7 13".split(" ") -> ["1", "4", ....]
        List<Integer> numbers = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //начин 1
        //лист -> върнем мин число
        /*Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
        System.out.println(getMinNumber.apply(numbers));*/

        //начин 2
        //лист -> отпечатаме мин число
        Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        printMinNumber.accept(numbers);

        //начин 3
        //System.out.println(Collections.min(numbers));


    }
}
