package by.academy.classwork.lesson10;

import by.academy.deal.entities.Chips;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        Chips testChips = new Chips("Chips", 10, 1, "Lays", "Cheese");
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("src\\\\io\\user.txt"))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(testChips);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("src\\io\\user.txt"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Chips chipsDeser = (Chips) objectInputStream.readObject();
            System.out.println(chipsDeser);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
