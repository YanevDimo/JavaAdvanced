package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P3MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int cout = 1; cout <= n; cout++) {
            String command = scanner.nextLine();
            if ("2".equals(command)) {
                stack.pop();
            } else if ("3".equals(command)) {
                if (stack.size() > 0) {
                    System.out.println(Collections.max(stack));
                }
            } else {
                int x = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(x);
            }
        }
    }
}
