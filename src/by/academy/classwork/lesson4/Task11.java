package by.academy.classwork.lesson4;

import java.util.Locale;
//a) Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
//б) Распечатать последний символ строки. Используем метод String.charAt().
//в) Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
//г) Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
//д) Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
//e) Найти позицию подстроки “Java” в строке “I like Java!!!”.
//ж) Заменить все символы “а” на “о”.
//з) Преобразуйте строку к верхнему регистру.
//и) Преобразуйте строку к нижнему регистру.
//к) Вырезать строку Java c помощью метода String.substring().

public class Task11 {
    public static void main(String[] args) {
        String str = "I like Java!!!";
        System.out.println(str.charAt(str.length()-1));
        String str1 = str.substring(str.indexOf("Java"),str.lastIndexOf("Java")+4);
        System.out.println(str1);
        System.out.println(str.endsWith("!!!"));
        System.out.println(str.startsWith("I like"));
        System.out.println(str.contains("Java"));
        System.out.println(str.indexOf("Java"));
        System.out.println(str.replace("a","o"));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());

    }
}
