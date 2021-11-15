package SetsAndMapsAdvancedLab;

import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        while (!input.equals("END")){
            if (Character.isDigit(input.charAt(0))){
                vip.remove(input);
            } else {
                regular.remove(input);
            }
            input = scanner.next();
        }
        System.out.println(vip.size() + regular.size());
        printSetIfNotEmpty(vip);
        printSetIfNotEmpty(regular);

    }

    public static void printSetIfNotEmpty(Set<String> set) {
        if (!set.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }
}
