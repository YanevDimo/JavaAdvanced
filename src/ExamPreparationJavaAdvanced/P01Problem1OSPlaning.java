package ExamPreparationJavaAdvanced;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Problem1OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> taskValueStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(taskValueStack::push);


        ArrayDeque<Integer> threadValueQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int killedTask = Integer.parseInt(scanner.nextLine());

        while (!threadValueQueue.isEmpty() && !taskValueStack.isEmpty()) {
//            for (int i = 0; i < threadValueQueue.size(); i++) {


            int checkQueue = threadValueQueue.peek();
            int checkStack = taskValueStack.peek();
            if (checkStack == killedTask || checkQueue == killedTask) {
                break;
            }
            if (checkStack <= checkQueue) {
                taskValueStack.pop();
                threadValueQueue.poll();
            } else {
                threadValueQueue.poll();
            }
        }
//        }
        for (Integer integer : threadValueQueue) {
            System.out.print("Thread with value " + integer);
            break;
        }
        System.out.println(" killed task " + killedTask);
        System.out.println(threadValueQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}