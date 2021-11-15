package EXAM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01DatingAppByMarto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int female = femalesQueue.peek();
            int male = malesStack.peek();

            if (female <= 0) {
                femalesQueue.poll();
                continue;
            } else if (male <= 0) {
                malesStack.pop();
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            } else if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (female == male) {
                matches++;
                femalesQueue.poll();
                malesStack.pop();
            }else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }
        System.out.println("Matches: " + matches);
        System.out.println("Males left: " + formatArrayDeck(malesStack));
        System.out.println("Females left: " + formatArrayDeck(femalesQueue));
    }

    // форматиране на deque
    private static String formatArrayDeck(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        }
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
