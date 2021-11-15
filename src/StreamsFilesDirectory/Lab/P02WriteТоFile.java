package StreamsFilesDirectory.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Set;

public class P02WriteТоFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        FileInputStream fileStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out.txt");

        int value = fileStream.read();
        Set<Character> punctuations = Set.of(',','.','!','?');
        while (value != -1) {

            char current = (char) value;
            if (!punctuations.contains(current)) {
                outputStream.write(current);
            }
            value = fileStream.read();
        }
    }
}
