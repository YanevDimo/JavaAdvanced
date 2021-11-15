package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        String input = scanner.nextLine();
        boolean areBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentBrackets = input.charAt(i);
            if (currentBrackets == '{' || currentBrackets == '[' || currentBrackets == '(') {
                openBrackets.push(currentBrackets);
            } else if (currentBrackets == '}' || currentBrackets == ']' || currentBrackets == ')') {
                if (openBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char open = openBrackets.pop();
                if (currentBrackets == '}' && open != '{') {
                    areBalanced = false;
                } else if (currentBrackets == ']' && open != '[') {
                    areBalanced = false;
                } else if (currentBrackets == ')' && open != '(') {
                    areBalanced = false;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
