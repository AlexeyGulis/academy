package by.academy.homework.hmwk2;

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
        //  Метод использует реплейс. т.к. в реплейсе есть цикл, тогда выполнение данного кода будет i^2 итераций
        if(str1.length()!=str2.length()){
            System.out.println(flag);
        }else {
            char[] temp1 = str1.toCharArray();
            for (int i = 0; i < temp1.length; i++) {
                if(str1.replace(Character.toString(temp1[i]),"").length()==str2.replace(Character.toString(temp1[i]),"").length()){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
        scan.close();

    }

}
