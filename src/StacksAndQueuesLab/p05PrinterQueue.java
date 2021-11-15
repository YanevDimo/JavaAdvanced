package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> command = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (command.isEmpty()){
                    System.out.println("Printer is on standby");
                }
                for (String element : command) {
                    System.out.println("Canceled " + element);

                }
                command.poll();
            } else if (!command.contains(input)) {
                command.offer(input);
            }
            input = scanner.nextLine();
        }

    }
}