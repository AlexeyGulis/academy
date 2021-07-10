package by.academy.lesson3;

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
