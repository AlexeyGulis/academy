package by.academy.classwork.lesson3;

//Составьте программу, котораЯ вычисляет сумму чисел от 1 до n.значение n вводится с клавиатуры.

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        int a = 1;
        int sum = 0;
        while (a<=i){
            sum+=a;
            a++;
        }
        System.out.println(sum);
        scan.close();
    }
}
