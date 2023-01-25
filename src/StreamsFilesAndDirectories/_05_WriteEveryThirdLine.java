package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\svetl\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String fileRead = "\\input.txt";
        String fileWrite = "\\05output.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(basePath + fileRead));
        PrintStream printStream = new PrintStream(basePath + fileWrite);
        int count = 1;
        String line = bufferedReader.readLine();
        while (line != null){
            if (count % 3 == 0){
                printStream.println(line);
            }
            count++;
            line = bufferedReader.readLine();
        }
    }
}
