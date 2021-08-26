package by.academy.classwork.lesson11;

import java.util.function.Predicate;

public class Task5 {
    public static void main(String[] args) {
        Predicate<String> j = str -> str.charAt(0) == 'J';
        Predicate<String> n = str -> str.charAt(0) == 'N';
        Predicate<String> a = str -> str.charAt(str.length() - 1) == 'A';
        System.out.println(j.or(n).and(a).test("JAVCA"));
        System.out.println(j.or(n).and(a).test("JAVCAC"));
    }
}
