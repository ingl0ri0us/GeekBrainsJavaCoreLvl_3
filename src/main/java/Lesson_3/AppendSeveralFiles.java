package Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class AppendSeveralFiles {
    static File file1 = new File("src/main/java/Lesson_3/files/test1.txt");
    static File file2 = new File("src/main/java/Lesson_3/files/test2.txt");
    static File file3 = new File("src/main/java/Lesson_3/files/test3.txt");
    static File file4 = new File("src/main/java/Lesson_3/files/test4.txt");
    static File file5 = new File("src/main/java/Lesson_3/files/test5.txt");
    static File fileAppended = new File("src/main/java/Lesson_3/files/testAppended.txt");

    public static void main(String[] args) {
        ArrayList<InputStream> listOfStreams = new ArrayList<>();
        try {
            listOfStreams.add(new FileInputStream(file1));
            listOfStreams.add(new FileInputStream(file2));
            listOfStreams.add(new FileInputStream(file3));
            listOfStreams.add(new FileInputStream(file4));
            listOfStreams.add(new FileInputStream(file5));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(listOfStreams));

        try {
            PrintWriter writer = new PrintWriter(fileAppended,"Unicode");

            int x;

            while((x = sequenceInputStream.read()) != -1) {
                writer.write((char) x);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
