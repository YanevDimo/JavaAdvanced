package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean areBalance = false;
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        for (int index = 0; index < input.length(); index++) {
            char currentBrackets = input.charAt(index);
            if (currentBrackets == '(' || currentBrackets == '{' || currentBrackets == '[') {
                openBrackets.push(currentBrackets);
            } else if (currentBrackets == ')' || currentBrackets == '}' || currentBrackets == ']') {
                char lastOpenBracket = openBrackets.pop();
                if (lastOpenBracket == '(' && currentBrackets == ')') {
                    areBalance = true;
                } else if (lastOpenBracket == '{' && currentBrackets == '}') {
                    areBalance = true;
                } else if (lastOpenBracket == '[' && currentBrackets == ']') {
                    areBalance = true;
                } else {
                    areBalance = false;
                    break;
                }
            }
        }
        if (areBalance) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
