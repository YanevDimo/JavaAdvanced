package StreamsFilesDirectory.Lab;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        String path = "input.txt";
        FileInputStream fileStream = new FileInputStream(path);

        int nextByte = fileStream.read();
        while (nextByte != -1) {
//            System.out.print((char) nextByte);// печата текст
            System.out.print(Integer.toBinaryString(nextByte) + " "); // печата бинарен код
            nextByte = fileStream.read();
        }
    }
}
