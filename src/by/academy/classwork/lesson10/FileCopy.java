package by.academy.classwork.lesson10;

import java.io.*;

public class FileCopy {
    public static final String INPUT_FILE_PATH = "src\\io\\file.txt";
    public static final String OUTPUT_FILE_PATH = "src\\io\\copied_file.txt";
    public static final String OUTPUT1_FILE_PATH = "src\\io\\copied_file1.txt";
    public static void main(String[] args) throws IOException {
        File dir = new File("scr\\io");
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(INPUT_FILE_PATH);
        if(!file.exists()){
            file.createNewFile();
        }
        File copyFile = new File(OUTPUT_FILE_PATH);
        if(!copyFile.exists()){
            copyFile.createNewFile();
        }
        File copyFile1 = new File(OUTPUT1_FILE_PATH);
        if(!copyFile1.exists()){
            copyFile1.createNewFile();
        }
        FileInputStream fileInput = new FileInputStream(INPUT_FILE_PATH);
        FileOutputStream fileOutput = new FileOutputStream(OUTPUT_FILE_PATH);
        FileOutputStream fileOutput1 = new FileOutputStream(OUTPUT1_FILE_PATH);
        int a;
        while( (a = fileInput.read()) != -1){
            fileOutput1.write(a);
        }
        byte[] b = fileInput.readAllBytes();
        fileOutput.write(b);


        fileInput.close();
        fileOutput.close();
        fileOutput1.close();
    }
}
