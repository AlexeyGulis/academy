package by.academy.homework.hmwk6.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StringStop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        File dir = new File("src\\by\\academy\\homework\\hmwk6\\task1");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File("src\\by\\academy\\homework\\hmwk6\\task1\\str.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Type string in file, if u want exit, type: stop");
        try (FileWriter strFile = new FileWriter(file)) {
            String str = scan.nextLine();
            while (!str.equals("stop")) {
                stringBuilder.append(str).append("\r\n");
                str = scan.nextLine();
            }
            strFile.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        scan.close();
    }
}
