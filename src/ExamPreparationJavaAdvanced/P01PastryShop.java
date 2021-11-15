package ExamPreparationJavaAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> cookingTablee = new LinkedHashMap<>();
        cookingTablee.put("Biscuit", 0);
        cookingTablee.put("Cake", 0);
        cookingTablee.put("Pie", 0);
        cookingTablee.put("Pastry", 0);

        while (!ingredientsStack.isEmpty() && !liquidsQueue.isEmpty()) {
            int sum = ingredientsStack.peek() + liquidsQueue.peek();

            if (sum == 25) {
                cookingTablee.put("Biscuit", cookingTablee.get("Biscuit") + 1);
                ingredientsStack.pop();
                liquidsQueue.poll();
            } else if (sum == 50) {
                cookingTablee.put("Cake", cookingTablee.get("Cake") + 1);
                ingredientsStack.pop();
                liquidsQueue.poll();
            } else if (sum == 75) {
                cookingTablee.put("Pastry", cookingTablee.get("Pastry") + 1);
                ingredientsStack.pop();
                liquidsQueue.poll();
            } else if (sum == 100) {
                cookingTablee.put("Pie", cookingTablee.get("Pie") + 1);
                ingredientsStack.pop();
                liquidsQueue.poll();
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }
        if (cookingTablee.values().stream().allMatch(p -> p >= 1)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquidsQueue.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        cookingTablee.forEach((k, v) ->
                System.out.println(k + ": " + v));
}
}
