package by.academy.homework.hmwk5.task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> markList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            markList.add(r.nextInt(10) + 1);
        }
        for (Integer integer : markList) {
            System.out.println(integer);
        }
        int maxMark = 0;
        int temp;
        Iterator<Integer> iterator = markList.iterator();
        while (iterator.hasNext()) {
             temp = iterator.next();
            if (maxMark < temp) {
                maxMark = temp;
            }
        }
        System.out.println("Max Mark = " + maxMark);
    }
}
