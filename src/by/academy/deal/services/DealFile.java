package by.academy.deal.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DealFile {
    public static void createFile(String data, String date) throws IOException {
        File dir = new File("src\\by\\academy\\deal");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File("src\\by\\academy\\deal\\deal-" + date + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(data);
        fileWriter.close();
    }
}
