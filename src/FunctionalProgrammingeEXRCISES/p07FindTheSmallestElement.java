package FunctionalProgrammingeEXRCISES;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p07FindTheSmallestElement {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //начин 1
        //приемаме списък -> отпечатваме индексът на най-малкото число
        /*Consumer<List<Integer>> printIndexOfMinElement = list -> {
            int min = Collections.min(list);
            System.out.println(list.lastIndexOf(min));
        };

        printIndexOfMinElement.accept(numbers);*/

        //приемаме списък -> връщаме индексът на най-малкото число
        Function<List<Integer>, Integer> getIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getIndexOfMinElement.apply(numbers));



    }
}
