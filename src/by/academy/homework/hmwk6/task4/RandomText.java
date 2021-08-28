package by.academy.homework.hmwk6.task4;

import java.io.*;
import java.util.Random;

public class RandomText {
    public static void main(String[] args) {
        Random r = new Random();
        File dir = new File("src\\by\\academy\\homework\\hmwk6\\task4\\catalog");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file;
        for (int i = 0; i < 100; i++) {
            file = new File("src\\by\\academy\\homework\\hmwk6\\task4\\catalog\\" + (i + 1) + ".txt");
            try {
                if(!file.exists()){
                    file.createNewFile();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        file = new File("src\\by\\academy\\homework\\hmwk6\\task2\\textFile.txt");
        if(!file.exists()){
            System.out.println("Создайте файл с текстом");
            return;
        }
        String text;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            text = bufferedReader.readLine();
            for (int i = 0; i < 100; i++) {
                file = new File("src\\by\\academy\\homework\\hmwk6\\task4\\catalog\\" + (i + 1) + ".txt");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text.substring(0,r.nextInt(text.length())));
                fileWriter.close();
            }
            file = new File("src\\by\\academy\\homework\\hmwk6\\task4\\result.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            File[] files = dir.listFiles();
            for (File f: files
                 ) {
                fileWriter.write("Имя файла: " + f.getName() + "; Размер в байтах: " + f.length() + "\r\n");
            }
            fileWriter.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
