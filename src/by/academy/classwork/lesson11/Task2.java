package by.academy.classwork.lesson11;

import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) {
        Predicate t1 = (str) -> str!=null;
        System.out.println(t1.test("hello"));
        System.out.println(t1.test(null));

        Predicate t2 = str -> str!="";
        System.out.println(t2.test(""));

        System.out.println(t2.test("123"));

        System.out.println(t1.and(t2).test("123"));

        System.out.println(t1.and(t2).test(""));

        System.out.println(t1.and(t2).test(null));
    }
}
