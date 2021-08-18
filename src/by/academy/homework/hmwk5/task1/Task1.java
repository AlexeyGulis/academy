package by.academy.homework.hmwk5.task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Integer[] numb = {1, 2, 3, 4, 1, 6, 8, 3, 1, 5, 6};
        List<Integer> arr = new LinkedList<>(Arrays.asList(numb));
        arr.forEach((n) -> {
            System.out.print(n + " ");
        });
        System.out.println();
        System.out.println("No duplicates");

        noDuplicates(arr);
        arr.forEach((n) -> {
            System.out.print(n + " ");
        });
        System.out.println();
    }

    private static <T> void noDuplicates(Collection<T> collection) {
        Set<T> noDupl = new HashSet<>(collection);
        collection.clear();
        collection.addAll(noDupl);
    }
}
