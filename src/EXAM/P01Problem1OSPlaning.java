package EXAM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Problem1OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(taskStack::push);

        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int numToKill = Integer.parseInt(scanner.nextLine());

        while (true) {

            int task = taskStack.peek();
            int thread = threadsQueue.peek();

            if (thread == numToKill || task == numToKill) {
                break;
            }
            if (thread >= task) {
                threadsQueue.poll();
                taskStack.pop();
            } else {
                threadsQueue.poll();
            }

        }
        System.out.println("Thread with value " + threadsQueue.peek() + " killed task " + numToKill);
        System.out.println(threadsQueue.stream().map(String::valueOf).collect(Collectors.joining("" + " ")));

    }
}
