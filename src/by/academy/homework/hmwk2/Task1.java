package by.academy.homework.hmwk2;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        System.out.print("Введите первую строку : ");
        String str1 = scan.nextLine();
        System.out.print("Введите вторую строку : ");
        String str2 = scan.nextLine();
        System.out.print(" -> ");
        if (str1.length() != str2.length()) {
            System.out.println(flag);
        } else {
            /* Первая версия
            char[] temp1 = str1.toCharArray();
            for (int i = 0; i < temp1.length; i++) {
                if (str1.replace(Character.toString(temp1[i]), "").length() == str2.replace(Character.toString(temp1[i]), "").length()) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            Вторая версия
            */
            char[] chstr1 = str1.toCharArray();
            char[] chstr2 = str2.toCharArray();
            int[] eng1 = new int[128];
            int[] eng2 = new int[128];
            for (int i = 0; i < chstr1.length; i++) {
                eng1[chstr1[i]]++;
            }
            for (int i = 0; i < chstr2.length; i++) {
                eng2[chstr2[i]]++;
            }
            flag = Arrays.equals(eng1,eng2);
            System.out.println(flag);
        }
        scan.close();
    }
}
