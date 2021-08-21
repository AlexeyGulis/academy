package by.academy.classwork.lesson10;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileDemo{
    public static void main(String[] args) throws IOException {
        File file = new File("src\\io");
        if(!file.exists()){
            System.out.println("Создали директорию");
            file.mkdir();
        }
        File fileTxt = new File("src\\io\\file.txt");
        if(!fileTxt.exists()){
            System.out.println("Создали файл");
            fileTxt.createNewFile();
        }
        File userTxt = new File("src\\io\\user.txt");
        if(!userTxt.exists()){
            System.out.println("Создали файл");
            userTxt.createNewFile();
        }
        printFileInfo(fileTxt);
        System.out.println();
        printFileInfo(userTxt);

    }
    public static void printFileInfo(File f){
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(f.lastModified()), ZoneId.systemDefault());
        System.out.println("Имя файла: " + f.getName());
        System.out.println("Путь к файлу: " + f.getAbsolutePath());
        System.out.println("Размер файла (байты): " + f.length());
        System.out.println("Дата последнего изменения: " + dateTime);
    }
}
