package SetsAndMapsAdvancedExercises;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class P7MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path pathFile1 = Path.of("C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt");
        List<String> allLinesFirstFile = Files.readAllLines(pathFile1);
        Path pathFileTwo = Path.of("C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt");
        List<String> allLineSecondFile = Files.readAllLines(pathFileTwo);

        PrintWriter writer = new PrintWriter("outputMerge.txt");
        allLinesFirstFile.forEach(writer::println);
        allLineSecondFile.forEach(writer::println);

        writer.close();
    }
}
