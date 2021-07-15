package by.academy.homework.hmwk1;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = 0;
        do{
            System.out.println("Введите число от 1 до 10");
            value = scan.nextInt();
        }while(value<1 || value>10);
        for (int i = 0; i < 10; i++) {
            System.out.println(value + "*" + i + "=" + value*i);
        }
        scan.close();
    }
}
