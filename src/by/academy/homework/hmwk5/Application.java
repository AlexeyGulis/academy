package by.academy.homework.hmwk5;

import java.util.*;

public class Application {
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


        ArrayList<Integer> timeArrayList = new ArrayList<>();
        LinkedList<Integer> timeLinkedList = new LinkedList<>();
        /*addElem(timeLinkedList);
        addElem(timeArrayList);
        timeLinkedList.forEach((n) -> {
            System.out.print(n + " ");
        });
        getElemArray(timeArrayList);*/
    }

    public static void addElem(Collection<Integer> collection) {
        for (int i = 0; i < 1_000_000; i++) {
            collection.add(i);
        }
    }

    public static void getElemArray(ArrayList<Integer> arrayList) {
        Random r = new Random();
        for (int i = 0; i < 100_000; i++) {
            System.out.print(arrayList.get(r.nextInt(1_000_000)) + " ");
        }
    }

    public static Collection<?> noDuplicates(Collection<?> collection) {
        Collection<?> noDuplicates = new ArrayList<>(new HashSet<>(collection));
        return noDuplicates;
    }
}
