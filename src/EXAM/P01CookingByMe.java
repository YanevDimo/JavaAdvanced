package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class P01CookingByMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> cookingTable = new TreeMap<>();
        cookingTable.put("Bread", 0);
        cookingTable.put("Cake", 0);
        cookingTable.put("Pastry", 0);
        cookingTable.put("Fruit Pie", 0);

        while (!liquidQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = ingredientsStack.peek() + liquidQueue.peek();

            switch (sum) {
                case 25:
                    cookingTable.put("Bread", cookingTable.get("Bread") + 1);
                    ingredientsStack.pop();
                    liquidQueue.poll();
                    break;
                case 50:
                    cookingTable.put("Cake", cookingTable.get("Cake") + 1);
                    ingredientsStack.pop();
                    liquidQueue.poll();
                    break;
                case 75:
                    cookingTable.put("Pastry", cookingTable.get("Pastry") + 1);
                    ingredientsStack.pop();
                    liquidQueue.poll();
                    break;
                case 100:
                    cookingTable.put("Fruit Pie", cookingTable.get("Fruit Pie") + 1);
                    ingredientsStack.pop();
                    liquidQueue.poll();
                    break;
                default:
                    liquidQueue.poll();
                    ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }
        if (getInfoForCookedMeal(cookingTable)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println("Liquids left: " + getElementsInfo(liquidQueue));
        System.out.println("Ingredients left: " + getElementsInfo(ingredientsStack));

        cookingTable.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static boolean getInfoForCookedMeal(Map<String, Integer> cookingTable) {
        for (Integer count : cookingTable.values()) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }
}