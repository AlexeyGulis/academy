package by.academy.homework1;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        int value_int = 0;
        String value_str = null;
        double value_dbl = 0.0;
        float value_flt = 0;
        char value_chr = 0;
        System.out.println("Введите тип данных: ");
        System.out.println("1 - int ");
        System.out.println("2 - double ");
        System.out.println("3 - float ");
        System.out.println("4 - char ");
        System.out.println("5 - String ");
        input = scan.nextInt();
        switch (input){
            case 1 :
                System.out.println("Введите значение переменной: ");
                value_int = scan.nextInt();
                System.out.println(value_int % 2);
                break;
            case 2 :
                System.out.println("Введите значение переменной: ");
                value_dbl = scan.nextDouble();
                System.out.println(value_dbl*0.7);
                break;
            case 3 :
                System.out.println("Введите значение переменной: ");
                value_flt = scan.nextFloat();
                System.out.println(value_flt*value_flt);
                break;
            case 4 :
                System.out.println("Введите значение переменной: ");
                value_chr = scan.next().charAt(0);
                System.out.println((int) value_chr);
                break;
            case 5 :
                System.out.println("Введите значение переменной: ");
                value_str = scan.nextLine();
                System.out.println("Hello " + value_str);
                break;
            default:
                System.out.println("Unsupported type ");
        }
        scan.close();
    }

}
