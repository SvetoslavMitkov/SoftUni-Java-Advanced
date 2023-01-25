package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class _04_ExtractInteger {

    public static void main(String[] args) throws FileNotFoundException {

        String basePath = "C:\\Users\\svetl\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String fileRead = "\\input.txt";
        String fileWrite = "\\04output.txt";

        Scanner scanner = new Scanner(new FileInputStream(basePath + fileRead));
        PrintStream print = new PrintStream(new FileOutputStream(basePath + fileWrite));

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                print.println(scanner.nextInt());
            }
            scanner.next();
        }

    }
}
