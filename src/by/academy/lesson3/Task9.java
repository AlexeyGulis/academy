package by.academy.lesson3;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int countmin = 0;
        int countpol = 0;
        int countzero = 0;
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            if(num>0)countpol++;else if(num<0){countmin++;}else countzero++;
        }
        System.out.println("Колличество положительных "+ countpol + ". Количество отрицательных " + countmin + ". Количество нулей " + countzero);
        scan.close();
    }
}
