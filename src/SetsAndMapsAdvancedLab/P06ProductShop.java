package SetsAndMapsAdvancedLab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopWithPrice = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] params = input.split(", ");
            String shop = params[0];
            String product = params[1];
            double price = Double.parseDouble(params[2]);

            shopWithPrice.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> productAndPrices = shopWithPrice.get(shop);
            productAndPrices.put(product, price);
            input = scanner.nextLine();

        }
        for (String shop : shopWithPrice.keySet()) {
            System.out.println(shop + "->");
            for (var entry : shopWithPrice.get(shop).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n",entry.getKey(),entry.getValue());
            }
        }
    }
}
