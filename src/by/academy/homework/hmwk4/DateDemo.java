package by.academy.homework.hmwk4;

import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) {
        String date;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите дату (Формат:dd-MM-yyyy): ");
        date = scan.nextLine();
        Date date1 = new Date(date);
        if (date1.getDate() != "Date Invalid") {
            date1.getDayOfWeekEnum();
            System.out.println("LeapYear -> " + date1.isLeapYear());
            System.out.println(date1.getDate());
        }
        System.out.println("Введите дату (Формат:dd-MM-yyyy): ");
        date = scan.nextLine();
        Date date2 = new Date(date);
        if (date2.getDate() != "Date Invalid") {
            date2.getDayOfWeekEnum();
            System.out.println("LeapYear -> " + date2.isLeapYear());
            System.out.println(date2.getDate());
        }
        System.out.println("------");
        date1.getDateInDays(date2);
        scan.close();
    }
}
