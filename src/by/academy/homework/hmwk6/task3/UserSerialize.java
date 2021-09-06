package by.academy.homework.hmwk6.task3;

import by.academy.deal.entities.Chips;

import java.io.*;
import java.util.ArrayList;

public class UserSerialize {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Овчаренко", "Феликс", 25));
        users.add(new User("Дорофеев", "Ярослав", 16));
        users.add(new User("Передрий", "Устин", 32));
        users.add(new User("Максимов", "Ян", 46));
        users.add(new User("Бутко", "Юлий", 29));
        users.add(new User("Егорова", "Зинаида", 20));
        users.add(new User("Матвеева", "Светлана", 27));
        users.add(new User("Рымар", "Елизавета", 33));
        users.add(new User("Колесникова", "Василиса", 24));
        users.add(new User("Афанасьева", "Розалина", 39));
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
        File[] userGet = dir.listFiles();
        for (File f : userGet
        ) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(f))) {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                User userSer = (User) objectInputStream.readObject();
                System.out.println(userSer);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
