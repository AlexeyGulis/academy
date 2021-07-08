package by.academy.lesson2;

import java.util.Scanner;

public class ScanDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(str);
        scan.close();
    }
}
