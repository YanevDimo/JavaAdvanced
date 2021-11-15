package SetsAndMapsAdvancedExercises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class P3ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        //Files.readAllLines(Path.of(path))
        //      .forEach(str -> System.out.println(str.toUpperCase()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        // FileOutputStream outputStream = new FileOutputStream("output.txt");
        Files.readAllLines(Path.of(path))
                .forEach(str -> {
                    try {
                        writer.write(str.toUpperCase());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }
}
