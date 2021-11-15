package EXAM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01MagiBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int finalSum = 0;
        while (!firstBoxQueue.isEmpty() || !secondBoxStack.isEmpty()) {

            int sum = firstBoxQueue.peek() + secondBoxStack.peek();

            if (sum % 2 == 0) {
                int deletedQ = firstBoxQueue.poll();
                int deletdS = secondBoxStack.pop();
                int sumDeleted = deletedQ + deletdS;
                finalSum += sumDeleted;
            } else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }
            if (firstBoxQueue.isEmpty()) {
                break;
            } else if (secondBoxStack.isEmpty()) {
                break;
            }
        }
        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (finalSum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + finalSum);
        } else {
            System.out.println("Poor prey... Value: " + finalSum);
        }
    }
}
