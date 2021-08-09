package by.academy.homework.hmwk4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ApplicationDemo {
    public static void main(String[] args) {
        ApplicationDemo.demoDate();
        System.out.println();
        System.out.println();
        System.out.println();
        ApplicationDemo.demoGenericArray();
    }

    public static void demoDate() {
        Scanner scanner = new Scanner(System.in);
        String date = "01-10-2004";
        DateValidate dateValid = new DateValidate();
        Date date1 = null;
        Date date2 = null;
        boolean flag = true;
        if (dateValid.validateDate(date)) {
            date1 = new Date(date);
            System.out.println(date1.getDate());
            date1.getDayOfWeek();
            System.out.println("LeapYear -> " + date1.isLeapYear());
        } else {
            System.out.println("Invalid date");
            flag = false;
        }
        System.out.printf("Введите дату(Формат dd-MM-yyyy)");
        date = scanner.nextLine();
        if (dateValid.validateDate(date)) {
            date2 = new Date(date);
            date2.setDate(date);
            System.out.println(date2.getDate());
            date2.getDayOfWeek();
            System.out.println("LeapYear -> " + date2.isLeapYear());
        } else {
            System.out.println("Invalid date");
            flag = false;
        }
        if(flag){
            System.out.println("------");
            date1.getDaysBetweenDates(date2);
        }
        scanner.close();
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
        Iterator<Integer> iterator = array1.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
