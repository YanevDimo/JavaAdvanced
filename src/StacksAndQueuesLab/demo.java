package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>stackOfNum = new ArrayDeque<>();
        stackOfNum.push(10);
        stackOfNum.push(112);
        stackOfNum.push(23);
        System.out.println(stackOfNum.peek());
        stackOfNum.pop();
        stackOfNum.pop();
        stackOfNum.push(23);
        System.out.println(stackOfNum.peek());
        Integer file = stackOfNum.pop();

        ArrayDeque<Integer>queue = new ArrayDeque<>();
        queue.offer(12);
        queue.offer(23);
        queue.offer(34);
        System.out.println(queue.peek());
    }

}
