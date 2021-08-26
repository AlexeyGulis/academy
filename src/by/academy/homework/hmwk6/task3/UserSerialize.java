package by.academy.homework.hmwk6.task3;

import java.io.*;
import java.util.ArrayList;

public class UserSerialize {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("a1", "b1", 15));
        users.add(new User("a2", "b2", 16));
        users.add(new User("a3", "b3", 17));
        users.add(new User("a4", "b4", 18));
        users.add(new User("a5", "b5", 19));
        users.add(new User("a6", "b6", 20));
        users.add(new User("a7", "b7", 21));
        users.add(new User("a8", "b8", 22));
        users.add(new User("a9", "b9", 23));
        users.add(new User("a10", "b10", 24));
        File dir = new File("src\\by\\academy\\homework\\hmwk6\\task3\\users");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (User user : users
        ) {
            File file = new File("src\\by\\academy\\homework\\hmwk6\\task3\\users\\" + user.getFirstName() + "-" + user.getSecondName() + ".txt");
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(user);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
