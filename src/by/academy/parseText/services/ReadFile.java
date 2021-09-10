package by.academy.parseText.services;

import java.io.*;

public class ReadFile {
    public final static String DIRECTORY_FILE = "src\\by\\academy\\parseText\\io";
    public final static String FILE = "src\\by\\academy\\parseText\\io\\text.txt";

    public static boolean checkPath() {
        File dir = new File(DIRECTORY_FILE);
        if (!dir.exists()) {
            System.out.println("Добавьте директорию и файл");
            return false;
        }
        return true;
    }

    public static boolean checkFile() {
        File file = new File(FILE);
        if (!file.exists()) {
            System.out.println("Добавьте директорию и файл");
            return false;
        }
        return true;
    }

    public static String getText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE));
        StringBuilder br = new StringBuilder();
        String str = reader.readLine();
        while (str != null) {
            br.append(str).append("\n");
            str = reader.readLine();
        }
        return br.toString();
    }

}
