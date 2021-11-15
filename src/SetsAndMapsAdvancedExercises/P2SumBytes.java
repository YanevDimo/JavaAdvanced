package SetsAndMapsAdvancedExercises;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class P2SumBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        String path = "C:\\Users\\dimo\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        long sum = 0;
        for(byte value : Files.readAllBytes(Path.of(path))){
            if (value != 10 && value != 13){
                sum += value;
            }
        }

        System.out.println(sum);
    }
}

