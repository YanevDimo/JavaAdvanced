package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class newDmo {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> newNum  = new ArrayDeque<>();
        newNum.push(13);
        newNum.push(34);
        newNum.pop();
        newNum.peek();
        for (Integer integer : newNum) {
            System.out.println(integer);
        }
    }
}
