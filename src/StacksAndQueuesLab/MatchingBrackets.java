package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          String expression = scanner.nextLine();

        ArrayDeque<Integer>indexOfOpenBrackets = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '('){
                indexOfOpenBrackets.push(i);
            }else if (symbol == ')'){
                System.out.println(expression.substring(indexOfOpenBrackets.pop(),i + 1));
            }
        }
    }
}
