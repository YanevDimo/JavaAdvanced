package EXAM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01Planing {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = readStack();
        ArrayDeque<Integer> threads = readQueue();

        int terminalTask = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int thread = threads.peek();
            int task = tasks.peek();

            if (task == terminalTask) {
                System.out.printf("Thread with value %d killed task %d%n", thread, terminalTask);
                break;
            }

            threads.pop();
            if (thread >= task) {
                tasks.pop();
            }
        }

        if (!threads.isEmpty()) {
            System.out.println(threads.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }

    private static ArrayDeque<Integer> readStack() {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        getMembers(stack::push, ",\\s+");
        return stack;
    }

    private static ArrayDeque<Integer> readQueue() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        getMembers(queue::offer, "\\s+");
        return queue;
    }

    private static void getMembers(Consumer<Integer> operation, String separator) {
        Scanner scanner = null;
        assert false;
        Arrays.stream(scanner.nextLine().split(separator))
                .map(Integer::parseInt)
                .forEach(operation);
    }
}
