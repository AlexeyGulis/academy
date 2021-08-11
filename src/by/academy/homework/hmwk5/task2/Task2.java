package by.academy.homework.hmwk5.task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Number> timeArrayList = new ArrayList<>();
        LinkedList<Number> timeLinkedList = new LinkedList<>();
        addElemementsToList(timeArrayList, timeLinkedList);
        getElementsFromList(timeArrayList, timeLinkedList);
    }

    public static void addElemementsToList(ArrayList<Number> arrayList, LinkedList<Number> linkedList) {
        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    public static void getElementsFromList(ArrayList<Number> arrayList, LinkedList<Number> linkedList) {
        Random r = new Random();
        long startTimeList = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            arrayList.get(r.nextInt(1_000_000));
        }
        long resultTimeArrayList = System.currentTimeMillis() - startTimeList;
        System.out.println("Time for ArrayList = " + resultTimeArrayList);
        startTimeList = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            linkedList.get(r.nextInt(1_000_000));
        }
        long resultTimeLinkedList = System.currentTimeMillis() - startTimeList;
        System.out.println("Time for LinkedList = " + resultTimeLinkedList);
    }
}
