package by.academy.homework.hmwk5.task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Integer[] numb = {1, 2, 3, 4, 1, 6, 8, 3, 1, 5, 6};
        LinkedList<Integer> arr = new LinkedList<Integer>(Arrays.asList(numb));
        arr.forEach((n) -> {
            System.out.print(n + " ");
        });
        System.out.println();
        System.out.println("No duplicates");

        ArrayList<Integer> noDuplicatesArr = (ArrayList<Integer>) noDuplicates(arr);
        noDuplicatesArr.forEach((n) -> {
            System.out.print(n + " ");
        });
        System.out.println();
    }

    public static Collection<?> noDuplicates(Collection<?> collection) {
        Collection<?> noDuplicates = new ArrayList<>(new HashSet<>(collection));
        return noDuplicates;
    }
}
