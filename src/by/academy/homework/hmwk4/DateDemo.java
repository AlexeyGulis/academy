package by.academy.homework.hmwk4;

import java.text.ParseException;
import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        String date;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите дату: ");
        date = scan.nextLine();
        Date date1 = new Date(date);
        if (date1.getDate() != "Date Invalid") {
            date1.getDayOfWeek();
            System.out.println("LeapYear -> " + date1.isLeapYear(date1.y.getYear()));
            date1.getDateInDays();
            System.out.println(date1.getDate());
        }
       /* System.out.println("Введите дату: ");
        date = scan.nextLine();
        Date date2 = new Date(date);
        if (date2.getDate() != "Date Invalid") {
            date2.getDayOfWeek();
            System.out.println("LeapYear -> " + date2.isLeapYear(date2.y.getYear()));
        }
        System.out.println(date2.getDate());
        */
        scan.close();

    }
}
