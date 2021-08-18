package by.academy.homework.hmwk5.task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Number> timeArrayList = new ArrayList<>();
        List<Number> timeLinkedList = new LinkedList<>();
        addElemementsToList(timeArrayList);
        addElemementsToList(timeLinkedList);
        System.out.println("Time for get elements ArrayList -> " + getTime(timeArrayList) + " ms");
        System.out.println("Time for get elements LinkedList -> " + getTime(timeLinkedList) + " ms");
    }

    private static void addElemementsToList(List<Number> list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
    }

    private static void getElementsFromList(List<Number> list) {
        Random r = new Random();
        for (int i = 0; i < 100_000; i++) {
            list.get(r.nextInt(1_000_000));
        }
    }

    private static long getTime(List<Number> list) {
        long startTimeList = System.currentTimeMillis();
        getElementsFromList(list);
        return System.currentTimeMillis() - startTimeList;
    }
}

/*
Как можно видеть доступ к элементам в ArrayList намного быстрее чем в LinkedList.
Время доступа к элементу в ArrayList константое,
тогда как в LinkedList оно будет зависить от того где элемент находится,
то есть будет линейная функция, в зависимости от индекса.
(Стоит учесть что доступ в LinkedList к первому и последнему элементу такая же константа как и в ArrayList)
 */
