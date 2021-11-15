package SetAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int num = scanner.nextInt();
//        Set<String> userNameme = new LinkedHashSet();
//        for (int elemen = 0; elemen < num; elemen++) {
//            String name = scanner.nextLine();
//            userNameme.add(name);
//        }
//        System.out.println(String.join(System.lineSeparator(),userNameme));


                LinkedHashSet<String> usernames = new LinkedHashSet<>();
                int n = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < n; i++) {
                    String username = scanner.nextLine();
                    usernames.add(username);
                }

                usernames.forEach(System.out::println);
        /*for (String username : usernames) {
            System.out.println(username);
        }*/


    }
}

