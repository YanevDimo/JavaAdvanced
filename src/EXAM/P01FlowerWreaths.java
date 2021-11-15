package EXAM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int flowersWreaths = 0;
        int otherSum = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            if (liliesStack.peek() + rosesQueue.peek() == 15) {
                flowersWreaths++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (liliesStack.peek() + rosesQueue.peek() > 15) {
                liliesStack.push(liliesStack.pop() - 2);
            } else if (liliesStack.peek() + rosesQueue.peek() < 15) {
                otherSum += (liliesStack.peek() + rosesQueue.peek());
                liliesStack.pop();
                rosesQueue.poll();
            }
        }
        if (flowersWreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + flowersWreaths + " wreaths!");
        } else {
            int moreWraths = otherSum / 15;
            int wreathNeeded = 5 - (flowersWreaths + moreWraths);
            System.out.println("You didn't make it, you need " + wreathNeeded + " wreaths more!");

        }
    }
}
