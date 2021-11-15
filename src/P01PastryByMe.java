import java.util.*;
import java.util.stream.Collectors;

public class P01PastryByMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> cookingData = new LinkedHashMap<>();

        cookingData.put("Biscuit", 0);
        cookingData.put("Cake", 0);
        cookingData.put("Pie", 0);
        cookingData.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = liquidsQueue.poll() + ingredientsStack.peek();
            if (sum == 25) {
                cookingData.put("Biscuit", cookingData.get("Biscuit") + 1);
                ingredientsStack.pop();
            } else if (sum == 50) {
                cookingData.put("Cake", cookingData.get("Cake") + 1);
                ingredientsStack.pop();
            } else if (sum == 75) {
                cookingData.put("Pie", cookingData.get("Pie") + 1);
                ingredientsStack.pop();
            } else if (sum == 100) {
                cookingData.put("Pastry", cookingData.get("Pastry") + 1);
                ingredientsStack.pop();
            } else {
                ingredientsStack.push(ingredientsStack.pop() + 3);

            }
        }
        //проверка дали в мапа се съдържа поне 1 f
        if (cookingData.values().stream().allMatch(f -> f >= 1)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquidsQueue.isEmpty()) {
            System.out.println("none");
        } else {
            //печатане на останалото съдържание на опшката
            System.out.println(liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()) {
            System.out.println("none");
        } else {
            //печатане на останалото съдържание на стека
            System.out.println(ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        cookingData.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
    }
}
