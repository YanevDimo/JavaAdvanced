package SetAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> phoneBook = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phoneBook.put(name, number);
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phoneBook.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
            name = scanner.nextLine();
        }
    }
}