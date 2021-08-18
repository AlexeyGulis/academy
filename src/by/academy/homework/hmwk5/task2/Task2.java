package by.academy.homework.hmwk5.task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Number> timeArrayList = new ArrayList<>();
        List<Number> timeLinkedList = new LinkedList<>();
        addElemementsToList(timeArrayList);
        addElemementsToList(timeLinkedList);
        System.out.println( "Time for get elements ArrayList -> " + getTime(timeArrayList) + " ms");
        System.out.println( "Time for get elements LinkedList -> " + getTime(timeLinkedList) + " ms");
    }

    public static void addElemementsToList(List<Number> list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
    }
    public static void getElementsFromList(List<Number> list){
        Random r = new Random();
        for (int i = 0; i < 100_000; i++) {
            list.get(r.nextInt(1_000_000));
        }
    }

    public static long getTime(List<Number> list) {
        long startTimeList = System.currentTimeMillis();
        getElementsFromList(list);
        return System.currentTimeMillis() - startTimeList;
    }
}