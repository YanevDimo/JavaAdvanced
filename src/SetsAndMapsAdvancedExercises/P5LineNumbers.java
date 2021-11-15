package SetsAndMapsAdvancedExercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class P5LineNumbers {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(path))
                .forEach(line ->
                        writer.println(countRow++ + ". " + line));

        writer.close();
    }
}
