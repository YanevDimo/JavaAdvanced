package SetsAndMapsAdvancedExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class P1SumLines {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);

        String pathStr = "C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(pathStr);
        try {
            List<String> allLines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error while reading file!");
        }

//        allLines.stream().map(String::toCharArray). forEach (
//                charArray -> {
//                    int sum = 0;
//                    for (char symbol : charaArray) {
//                        sum += symbol;
//                    }
//
//      2  втори начин
//                    System.out.println(sum);
//        for (String line : allLines) {
//            int sum = 0;
//            for (int index = 0; index < line.length(); index++) {
//                char currentSymbol = line.charAt(index);
//                sum += currentSymbol;
//            }
//            System.out.println(sum);

    }
}

