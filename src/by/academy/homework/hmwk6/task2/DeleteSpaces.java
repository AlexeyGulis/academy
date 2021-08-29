package by.academy.homework.hmwk6.task2;

import java.io.*;

public class DeleteSpaces {
    public static void main(String[] args) {
        File dir = new File("src\\by\\academy\\homework\\hmwk6\\task2");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File sourceFile = new File("src\\by\\academy\\homework\\hmwk6\\task2\\textFile.txt");
        if (!sourceFile.exists()) {
            System.out.println("Create source File");
            return;
        }
        File resultFile = new File("src\\by\\academy\\homework\\hmwk6\\task2\\result.txt");
        try {
            if (!resultFile.exists()) {
                resultFile.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(resultFile)) {
            int b = inputStream.read();
            while (b != -1) {
                if (b != (int) ' ') {
                    outputStream.write(b);
                }
                b = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
