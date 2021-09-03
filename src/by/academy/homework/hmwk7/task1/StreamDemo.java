package by.academy.homework.hmwk7.task1;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    private static Map<String, Integer> map;

    public static void main(String[] args) {
        List<Integer> list = generateList(100, 100);
        map = list.stream().peek(n -> n = (int) (n * Math.PI) - 20).filter(n -> n < 100)
                .sorted().skip(3).distinct().collect(Collectors.toMap(k -> "Number: " + k, v -> v));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key - " + entry.getKey() + "; Value - " + entry.getValue());
        }
    }

    private static List<Integer> generateList(int count, int max) {
        return Stream.generate(() -> new Random().nextInt(max)).limit(count).collect(Collectors.toList());
    }
}
