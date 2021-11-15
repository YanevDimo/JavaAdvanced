package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine()//   четене от конзолата на опашка
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();//       четене на стака от конзолата
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<Integer, String> foodValues = new LinkedHashMap<>();
        foodValues.put(25, "Biscuit");
        foodValues.put(50, "Cake");
        foodValues.put(75, "Pastry");
        foodValues.put(100, "Pie");

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            if (foodValues.entrySet().stream().anyMatch(e -> e.getKey() == sum)) {
                String foodCooked = foodValues.get(sum);
                foods.put(foodCooked, foods.get(foodCooked) + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }
        if (foods.values().stream().allMatch(f -> f >= 1)) {
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
        foods.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
    }
}