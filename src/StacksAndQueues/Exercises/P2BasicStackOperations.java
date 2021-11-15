package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = scanner.nextInt(); // nextInt взима всеки следващ Инт
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {

                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }
    }
}

