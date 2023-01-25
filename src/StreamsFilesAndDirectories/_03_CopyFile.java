package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyFile {
    public static void main(String[] args) {

        String basePath = "C:\\Users\\svetl\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String fileRead = "\\input.txt";
        String fileWrite = "\\output.txt";

        try(FileInputStream fileInputStream = new FileInputStream(basePath + fileRead);
            FileOutputStream fileOutputStream = new FileOutputStream(basePath + fileWrite)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0){
                if (oneByte == ' ' || oneByte == '\n'){
                    fileOutputStream.write(oneByte);
                }else {
                    String currentASCII = String.valueOf(oneByte);
                    for (int i = 0; i < currentASCII.length(); i++) {
                        fileOutputStream.write(currentASCII.charAt(i));
                    }
                }
            oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
