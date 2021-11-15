package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class P01prepar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //fill the Queue
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        //fill the stack
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);


        Map<String, Integer> cookingTable = new TreeMap<>();
        cookingTable.put("Bread",0);
        cookingTable.put("Cake",0);
        cookingTable.put("Pastry",0);
        cookingTable.put("Fruit Pie",0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            switch (sum) {
                case 25:
                    coockedMeal(cookingTable,"Bread");
                    ingredientsStack.pop();
                    liquidsQueue.poll();
                    break;
                case 50:
                    coockedMeal(cookingTable,"Cake");
                    ingredientsStack.pop();
                    liquidsQueue.poll();
                    break;
                case 75:
                coockedMeal(cookingTable,"Pastry");
                    ingredientsStack.pop();
                    liquidsQueue.poll();
                    break;
                case 100:
                    coockedMeal(cookingTable,"Fruit Pie");
                    ingredientsStack.pop();
                    liquidsQueue.poll();
                    break;
                default:
                    liquidsQueue.poll();
                    ingredientsStack.push(ingredientsStack.pop() + 3);
            }

        }
        if (coockedEachMeal(cookingTable)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println("Liquids left: " + getElementsInfo(liquidsQueue));
        System.out.println("Ingredients left: " + getElementsInfo(ingredientsStack));

        cookingTable.forEach((k,v) ->{
            System.out.println(k +": "+v);
        });

    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
    private static boolean coockedEachMeal(Map<String, Integer> cookingTable) {
        for (Integer value : cookingTable.values()) {
            if (value == 0) {
                return false;
            }
        }
            return true;

    }

    private static void coockedMeal(Map<String, Integer> cookingTable,String kindOfMeal) {
        if (cookingTable.containsKey(kindOfMeal)) {
            int  count = cookingTable.get(kindOfMeal);
            cookingTable.put(kindOfMeal, count + 1);
        }
    }
}
