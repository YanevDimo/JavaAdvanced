package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class    P04BasicQueueOperations {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueNum = new ArrayDeque<>();
        String[] line = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);

        String[] input = scanner.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            queueNum.offer(Integer.parseInt(input[i]));
        }
        for (int j = 0; j < s; j++) {
            queueNum.poll();
        }
        if (queueNum.isEmpty()) {
            System.out.println(0);
        } else {
            if (queueNum.contains(x)) {
                System.out.println("true");
            } else {
                //  System.out.println(Collections.min(stackNum));//взима най малкият елемент от колекцията
                // или класическия начин е
                System.out.println(getMinElement(queueNum)); //метод за взимане на най малкия елемент
            }
        }
    }

    private static int getMinElement(ArrayDeque<Integer> stackNum) {
        int min = Integer.MAX_VALUE;
        for (Integer number : stackNum) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
