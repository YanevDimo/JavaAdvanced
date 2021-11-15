package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//
//        Datura Bombs: 40
//        Cherry Bombs: 60
//        Smoke Decoy Bombs: 120

        //Read Queue with API
        ArrayDeque<Integer> bombEffectsQueue = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // READ Stack WITH API
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombCasingStack::push);

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        while (!bombEffectsQueue.isEmpty() && !bombCasingStack.isEmpty()) {

            if (hasAllBombs(bombs)) break;
            int effect = bombEffectsQueue.peek();
            int casings = bombCasingStack.pop();

            int sum = effect + casings;
            if (sum == 40) {
                bombEffectsQueue.poll();
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
            } else if (sum == 60) {
                bombEffectsQueue.poll();
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
            } else if (sum == 120) {
                bombEffectsQueue.poll();
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
            } else {
                bombCasingStack.push(casings - 5);
            }
        }
        //"You don't have enough materials to fill the bomb pouch."
        if (hasAllBombs(bombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        String effectOutput = "Bomb Effects: "
                + (bombEffectsQueue.isEmpty()
                ? "empty"
                : bombEffectsQueue.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(effectOutput);

        String casingsOutput = "Bomb Casings: "
                + (bombCasingStack.isEmpty()
                ? "empty"
                :bombCasingStack.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(casingsOutput);

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
    }

    private static boolean hasAllBombs(Map<String, Integer> bombs) {
        return bombs.get("Cherry Bombs") >= 3 && bombs.get("Datura bombs") >= 3
                && bombs.get("Smoke Decoy Bombs") >= 3;
    }
}
