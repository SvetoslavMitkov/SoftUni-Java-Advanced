package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\svetl\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String fileRead = "\\input.txt";
        String fileWrite = "\\06output.txt";

        Path fileWritePath = Paths.get(basePath + fileWrite);
        Path fileReadPath = Paths.get(basePath + fileRead);

        List<String> allLines = Files.readAllLines(fileReadPath).stream().sorted().toList();

        Files.write(fileWritePath, allLines);

    }
}
