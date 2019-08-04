package Lesson_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadToArray {
    static File fileToRead = new File("src/main/java/Lesson_3/files/test1.txt");

    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(fileToRead)) {
            byte[] array = new byte[50];
            int x;
            for (int i = 0; i < array.length; i++) {
                array[i] = (byte) inputStream.read();
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print((char) array[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
