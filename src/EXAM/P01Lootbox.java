package EXAM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxStack::push);
        int sum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstBox = firstBoxQueue.peek();
            int secondBox = secondBoxStack.peek();
            int currentSum = firstBox + secondBox;

            if ((firstBox + secondBox) % 2 == 0) {
                firstBoxQueue.poll();
                secondBoxStack.pop();
                sum += currentSum;
            } else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }
//            if (firstBoxQueue.isEmpty() || secondBoxStack.isEmpty()) {
//                break;
//            }
        }
        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
