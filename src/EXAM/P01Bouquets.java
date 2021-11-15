package EXAM;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int countBouquet = 0;
        int otherSum = 0;


        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {

            int sum = tulipsStack.peek() + daffodilsQueue.peek();

            if (sum == 15) {
                countBouquet++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum > 15) {
                tulipsStack.push(tulipsStack.pop() - 2);
            } else {
                otherSum += sum;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }
        if (countBouquet < 5) {
            int bouquetNeeded = otherSum / 15;
            int missingBouquet = 5 - (countBouquet + bouquetNeeded);
            System.out.println("You failed... You need more " + missingBouquet + " bouquets.");
        } else {


            System.out.println("You made it! You go to the competition with " + countBouquet + " bouquets!");
        }

    }
}
