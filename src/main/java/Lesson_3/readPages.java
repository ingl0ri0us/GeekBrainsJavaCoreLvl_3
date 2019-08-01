package Lesson_3;

import java.io.*;

public class readPages {
    static File theBook = new File("src/main/java/Lesson_3/files/SherlockHolmes.txt");

    public static void main(String[] args) {
        System.out.println("Enter page number you want to read:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (RandomAccessFile raf = new RandomAccessFile(theBook,"r")) {
            int pageNumber = Integer.parseInt(reader.readLine());
            raf.seek(pageNumber * 1800);
            for (int i = 0; i < 1800; i++) {
                System.out.print((char) raf.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
