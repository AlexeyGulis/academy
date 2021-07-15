package by.academy.classwork.lesson3;

//Ввести с консоли 2 числа, найти большее, меньшее, среднее арифметическое.

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i1 = 0;
        int i2 = 0;
        System.out.println("Введите первое число");
        i1 = scan.nextInt();
        System.out.println("Введите второе число");
        i2 = scan.nextInt();
        if(i1<i2) System.out.println("Второе число больше первого");
        else if(i2<i1) System.out.println("Первое число больше второго");
        else System.out.println("Два числа одинаковы");
        System.out.println("Среднее арифмитическое двух чисел равно " + (i1 + i2)/2);
        scan.close();

    }
}
