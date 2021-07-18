package by.academy.homework.hmwk2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите две строки с четным количеством ");
        String[] str = new String[2];
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            str[i]=scanner.nextLine();
            while (true){
                if(chet(str[i])){
                    if(i==0) {
                        strb.append(str[i].substring(0, (str[i].length()) / 2));
                    }else strb.append(str[i].substring(str[i].length() / 2 , str[i].length()));
                    break;
                }
                System.out.println("Строка с нечетным количеством букв, повторите ввод ");
                str[i] = scanner.nextLine();
            }
        }
        strb.insert(0,"  ->  ");
        System.out.println("Первая строка " + str[0]);
        System.out.println("Вторая строка " + str[1]);
        System.out.println(strb.toString());

    }
    public static boolean chet(String str){
        if(str.length()%2==0){
            return true;
        }else return false;
    }
}
