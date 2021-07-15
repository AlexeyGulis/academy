package by.academy.homework.hmwk1;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int buy_sum = 0;
        int age = 0;
        String str = "Сумма покупки c учетом скидки равна ";
        System.out.println("Введите сумму покупки");
        buy_sum = scan.nextInt();
        System.out.println("Введите возраст покупателя");
        age = scan.nextInt();
        if(buy_sum<100){
            System.out.println(str + buy_sum*1.05);
        }else if(buy_sum<200 && buy_sum>=100){
            System.out.println(str + buy_sum*1.07);
        }else if(buy_sum<300 && buy_sum>=200){
            if(age>18){
                System.out.println(str + buy_sum*1.16);
            }else if(age<=18){
                System.out.println(str + buy_sum*1.09);
            }
        }else if(buy_sum<400 && buy_sum>=300){
            System.out.println(str + buy_sum*1.15);
        }else if(buy_sum>=400){
            System.out.println(str + buy_sum*1.20);
        }
        scan.close();
    }
}
