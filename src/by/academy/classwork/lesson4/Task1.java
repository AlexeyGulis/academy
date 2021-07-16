package by.academy.classwork.lesson4;

import java.util.Scanner;
//Ввести n строк с консоли, найти самую короткую и самую длинную строки.
//Вывести найденные строки и их длину.

public class Task1{
    public static void main(String[] args) {

        int n = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        n = scan.nextInt();
        System.out.println("Вводите строки ");
        String[] str = new String[n];
        int min = 0;
        int max = 0;
        boolean flag = true;
        for (int i = 0;i<n;i++) {
            str[i] = scan.nextLine();
            if (str[i]!= null && str[i].length()>max){max = i;}
            if (str[i]!= null && flag){min=i;}else if(str[i].length()<min){min=i;}
        }
        System.out.println("Самая короткая строка " + str[min]);
        System.out.println("Самая длинная строка " + str[max]);

    }
}
