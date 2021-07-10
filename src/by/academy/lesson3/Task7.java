package by.academy.lesson3;

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
