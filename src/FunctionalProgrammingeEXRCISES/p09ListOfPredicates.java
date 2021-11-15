package FunctionalProgrammingeEXRCISES;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class p09ListOfPredicates {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersForDivision = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //приема лист с числа и число -> връща true/ false
        //true -> числото се дели на всички числа
        //false -> числото не се дели на всички числа
        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (int numberInList : list) {
                if (number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });


        //всички числа от 1 до n
        for (int number = 1; number <= n; number++) {
            //проверка дали се дели на всички дадени числа
            if(isDivisible.apply(numbersForDivision, number)) {
                System.out.print(number + " ");
            }

        }

    }
}
