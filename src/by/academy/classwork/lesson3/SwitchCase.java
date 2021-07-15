package by.academy.classwork.lesson3;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите месяц года");
        String str = scan.nextLine();
        switch (str){
            case "январь" :
                System.out.println("Номер месяца: " + 1);break;
            case "февраль" :
                System.out.println("Номер месяца: " + 2);break;
            case "март" :
                System.out.println("Номер месяца: " + 3);break;
            case "апрель" :
                System.out.println("Номер месяца: " + 4);break;
            case "май" :
                System.out.println("Номер месяца: " + 5);break;
            case "июнь" :
                System.out.println("Номер месяца: " + 6);break;
            case "июль" :
                System.out.println("Номер месяца: " + 7);break;
            case "август" :
                System.out.println("Номер месяца: " + 8);break;
            case "сентябрь" :
                System.out.println("Номер месяца: " + 9);break;
            case "октябрь" :
                System.out.println("Номер месяца: " + 10);break;
            case "ноябрь" :
                System.out.println("Номер месяца: " + 11);break;
            case "декабрь" :
                System.out.println("Номер месяца: " + 12);break;
                default:
                    System.out.println("Неправильный формат месяца");
        }
        scan.close();
    }
}
