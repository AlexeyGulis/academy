package by.academy.classwork.lesson11;

import java.util.function.Function;

public class Task7 {
    public static void main(String[] args) {
        Function<Integer,String> zero = n -> {
            if(n>0)return "Положительное";
            else if(n<0) return "Отрицательное";
            else return "Ноль";
        };
        System.out.println(zero.apply(-10));
    }
}
