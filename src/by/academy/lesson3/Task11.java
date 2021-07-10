package by.academy.lesson3;

//Ввести с клавиатуры 10 пар чисел. сравнить числа в каждой паре и напечатать большие из них.

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        int i1 = 0;
        int i2 = 0;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            i1 = scan.nextInt();
            i2 = scan.nextInt();
            if (i1>i2) System.out.println(i1); else if(i1<i2) System.out.println(i2); else System.out.println(i1 + " " + i2);
        }
        scan.close();
    }
}
