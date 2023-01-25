package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\svetl\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0){
                String binary = Integer.toBinaryString(oneByte);
                System.out.print(binary + " ");

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
