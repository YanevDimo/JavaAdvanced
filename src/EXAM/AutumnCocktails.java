package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bucketOfIngredientsQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessLevelStack::push);

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (!bucketOfIngredientsQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {
            int sum = bucketOfIngredientsQueue.peek() * freshnessLevelStack.peek();

            if (!bucketOfIngredientsQueue.isEmpty()) {
                if (bucketOfIngredientsQueue.peek() == 0) {
                    bucketOfIngredientsQueue.poll();
                    continue;
                }
            }
            switch (sum) {
                case 150:
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    freshnessLevelStack.pop();
                    bucketOfIngredientsQueue.poll();
                    break;
                case 250:
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    freshnessLevelStack.pop();
                    bucketOfIngredientsQueue.poll();
                    break;
                case 300:
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    freshnessLevelStack.pop();
                    bucketOfIngredientsQueue.poll();
                    break;
                case 400:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    freshnessLevelStack.pop();
                    bucketOfIngredientsQueue.poll();
                    break;
                default:
                    freshnessLevelStack.pop();
                    if (!bucketOfIngredientsQueue.isEmpty()) {
                        bucketOfIngredientsQueue.offerLast(bucketOfIngredientsQueue.poll() + 5);
                    }

                    // TODO: 11/8/2021
            }
        }
    }
}