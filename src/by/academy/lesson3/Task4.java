package by.academy.lesson3;

// Перепишите программу:
//public class Main {
// public static void main(String[] args) {
//  int s = 370_000;
//  int sec;
//  int m;
//  int min;
//  int h;
//  sec = s % 60;
//  m = (s - sec) / 60;
//  min = m % 60;
//  h = (m - min) / 60;
//  System.out.println(h + " часов " + min + " минут " + sec + " секунд");
// }
//}
//// Продолжить пример, добавить расчет и вывод суток и недель. (месяц по желанию)

public class Task4 {
    public static void main(String[] args) {
        int s = 120_370_000;
        int sec;
        int m;
        int min;
        int h;
        int days;
        int h_m;
        int weeks;
        int days_m;
        int month;
        int weeks_m;
        sec = s % 60;
        m = (s - sec) / 60;
        min = m % 60;
        h = (m - min) / 60;
        h_m = h % 24;
        days = (h - h_m) / 24;
        days_m = days % 7;
        weeks = (days - days_m) / 7;
        weeks_m = weeks % 30;
        month = (weeks - weeks_m) / 30;
        System.out.println(  month + " месяцев " + weeks_m + " недель " + days_m + " дней "  + h_m + " часов " + min + " минут " + sec + " секунд");
    }

}
