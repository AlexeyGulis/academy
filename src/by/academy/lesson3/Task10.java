package by.academy.lesson3;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int money = 0;
        int year = 0;
        int procent = 3;
        Scanner scan = new Scanner(System.in);
        System.out.println("Количество денег");
        money = scan.nextInt();
        System.out.println("Количество лет");
        year = scan.nextInt();
        for (int i = 0; i < year; i++) {
            money = money + money * procent / 100;
        }
        System.out.println("Количество денег через " + year + " лет " + money);
        scan.close();
    }
}
