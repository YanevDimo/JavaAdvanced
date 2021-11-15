package SetsAndMapsAdvancedExercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class P6WordCount {
    public static void main(String[] args) throws IOException {


            String pathWords = "C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers";
            String pathText = "C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers";
            String outputPath = "outputCountWords.txt";
            PrintWriter writer = new PrintWriter(outputPath);
            LinkedHashMap<String, Integer> countWords = new LinkedHashMap<>();

            List<String> lines = Files.readAllLines(Path.of(pathWords));

            for (String line : lines) {
                Arrays.stream(line.split("\\s+")).forEach(
                        word ->
                                countWords.put(word, 0)
                );
            }


            for (String line : Files.readAllLines(Path.of(pathText))) {
                Arrays.stream(line.split("\\s+")).forEach(
                        word ->
                        {
                            if (countWords.containsKey(word)) {
                                countWords.put(word, countWords.get(word) + 1);
                            }
                        }
                );
            }


            for (Map.Entry<String, Integer> word : countWords.entrySet()) {
                writer.println(word.getKey() + " - " + word.getValue());
            }

            writer.close();

    }
}