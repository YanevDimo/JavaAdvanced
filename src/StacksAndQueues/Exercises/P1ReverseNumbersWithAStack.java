package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numbersStack = new ArrayDeque<>();
        //1.пълнене на стека с лист и стрийм!!!
//        List<String> inputData = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
//
//        for (String number : inputData) {
//            numbersStack.push(number);
//        }
        //2.пълнене с масив
//        String[] inputData = scanner.nextLine().split("\\s+");
//        for (int i = 0; i < inputData.length; i++) {
//            numbersStack.push(inputData[i]);
//        }

        //3.или може да се напиши и по този начин може би е и по правилно
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numbersStack::push);
//       !!! задължително се проверява дали не е празен стека, иначе ще даде грешка!!!
        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
           // принтиране с LAMDA
         //   numbersStack.forEach(n -> System.out.print(n + " "));
        }
    }
}

