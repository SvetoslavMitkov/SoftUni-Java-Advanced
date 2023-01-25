package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_WriteFile {
    public static void main(String[] args) throws FileNotFoundException {

        String basePath = "C:\\Users\\svetl\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String fileRead = "\\input.txt";
        String fileWrite = "\\output.txt";
        char[] charsToEscape = { ',','.','!','?'};
        List<Character> punctuation = new ArrayList<>();
        for (char c : charsToEscape) {
            punctuation.add(c);
        }

        try (FileInputStream fileInputStream = new FileInputStream(basePath + fileRead);
             FileOutputStream fileOutputStream = new FileOutputStream(basePath + fileWrite)) {
            int oneByte = fileInputStream.read();

            while (oneByte >= 0) {
                char currentChar  = (char) oneByte;
                if (!punctuation.contains(currentChar)) {
                    fileOutputStream.write(currentChar);
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
