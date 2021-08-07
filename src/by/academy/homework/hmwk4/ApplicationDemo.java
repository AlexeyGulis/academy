package by.academy.homework.hmwk4;

import java.util.Arrays;
import java.util.Iterator;

public class ApplicationDemo {
    public static void main(String[] args) {
        ApplicationDemo.demoDate();
        System.out.println();
        System.out.println();
        System.out.println();
        ApplicationDemo.demoGenericArray();
    }

    public static void demoDate() {
        String date = "01-10-2004";
        Date date1 = new Date(date);
        if (date1.getDate() != "Date Invalid") {
            System.out.println(date1.getDate());
            date1.getDayOfWeek();
            System.out.println("LeapYear -> " + date1.isLeapYear());
        }
        Date date2 = new Date();
        date2.setDate("18-06-1979");
        if (date2.getDate() != "Date Invalid") {
            System.out.println(date2.getDate());
            date2.getDayOfWeek();
            System.out.println("LeapYear -> " + date2.isLeapYear());
        }
        System.out.println("------");
        date1.getDateInDays(date2);
    }

    public static void demoGenericArray() {
        GenericArray<Integer> array1 = new GenericArray<>();
        GenericArray<Integer> array2 = new GenericArray<>(3);
        System.out.println(Arrays.toString(array1.getItems()));
        System.out.println(Arrays.toString(array2.getItems()));
        System.out.println(array1.getFirst());
        array1.add(3);
        array1.add(2);
        array1.add(3);
        array1.add(4);
        array1.add(5);
        array1.add(6);
        array1.add(7);
        array1.add(8);
        array1.add(9);
        System.out.println(Arrays.toString(array1.getItems()));
        array1.remove((Integer) 3);
        System.out.println(Arrays.toString(array1.getItems()));
        array2.set(2, 5);
        System.out.println(Arrays.toString(array2.getItems()));
        System.out.println(array1.getLast());
        Iterator<Integer> iter = array1.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
