package by.academy.classwork.lesson3;

//Создайте число. Определите, является ли число четным или не четным,
//вывести текстовое сообщение

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        if(a%2==0){
            System.out.println("Число " + a + " четное");
        } else System.out.println("Число " + a + " нечетное");
        scan.close();
    }
}
