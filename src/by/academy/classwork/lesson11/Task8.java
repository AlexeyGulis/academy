package by.academy.classwork.lesson11;

import java.util.Random;
import java.util.function.Supplier;

public class Task8 {
    public static void main(String[] args) {
        Random r = new Random();
        Supplier<Integer> te = () -> {
            return r.nextInt(10);
        };
        System.out.println(te.get());
    }
}
