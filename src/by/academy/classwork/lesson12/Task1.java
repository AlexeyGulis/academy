package by.academy.classwork.lesson12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    private static List<Integer> list;

    public static void main(String[] args) {
        list = generateList(1000, 1000);
        System.out.println("Max");
        System.out.println(list.stream().
                skip(50).filter(n -> n % 2 == 0).
                sorted().distinct()
                .max(Comparator.comparing(i -> Integer.valueOf(i))));
        System.out.println("Min");
        System.out.println(list.stream().
                skip(50).filter(n -> n % 2 == 0).
                sorted().distinct().min(Comparator.comparing(i -> Integer.valueOf(i))));
        System.out.println(" отсортированных четных неповторяющихся:");
        System.out.println(list.stream().
                skip(50).filter(n -> n % 2 == 0).
                sorted().distinct()
                .map((n) -> "Число " + n).limit(200)
                .collect(Collectors.toList()));
        System.out.println(list.stream().
                skip(50).filter(n -> n % 2 == 0).
                sorted().distinct()
                .map((n) -> "Число " + n).limit(200)
                .anyMatch(n -> "Число 500".equals(n)));
    }

    private static List<Integer> generateList(Integer f, Integer s) {
        Supplier<Integer> r = () -> new Random().nextInt(f);
        return Stream.generate(r).limit(s).collect(Collectors.toList());
    }
}
