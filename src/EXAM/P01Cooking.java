package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);


        //Queue -> пълнене на опашката
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        // пълнене на стека
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productCooked = new TreeMap<>();
        cookingTable.values()
                .forEach(p -> productCooked.put(p, 0));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();

            int sum = currentIngredient + currentLiquid;
            if (ableToCookProduct(sum)) {
                String product = cookingTable.get(sum);
                productCooked.put(product, productCooked.get(product) + 1);
            } else {
                ingredients.push(currentIngredient + 3);
            }
        }
        if (coockedEachMeal(productCooked)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println("Liquids left: " + getElementsInfo(liquids));
        System.out.println("Ingredients left: " + getElementsInfo(ingredients));

        productCooked.forEach((k, v) -> {System.out.println(k + ": " + v);});
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static boolean coockedEachMeal(Map<String, Integer> productCooked) {
        for (Integer count : productCooked.values()) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean ableToCookProduct(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
