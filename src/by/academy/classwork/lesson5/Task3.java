package by.academy.classwork.lesson5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Дана строка “Versions: Java  5, Java 6, Java   7, Java 8, Java 12.”
//Найти все подстроки "Java <X>" и распечатать их.
public class Task3 {
    static Pattern pattern = Pattern.compile("Java\\s+\\d+");
    public static void main(String[] args) {
        String str = "Versions: Java  5, Java 6, Java   7, Java 8, Java 12.";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
