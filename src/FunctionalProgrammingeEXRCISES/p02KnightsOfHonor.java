package FunctionalProgrammingeEXRCISES;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p02KnightsOfHonor {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        //name -> отпечатвам Sir + name
        Consumer<String> printName = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(printName);

        /*for (String name : names) {
            printName.accept(name);
        }*/




    }
}
