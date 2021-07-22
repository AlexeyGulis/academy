package by.academy.classwork.lesson5;
//1. Найти в строке не только запятые, но и другие знаки препинания. Подсчитать
//общее их количество
//2. Имеется строка с текстом. Подсчитать количество слов в тексте. Желательно
//учесть, что слова могут разделяться несколькими пробелами, в начале и конце
//текста также могут быть пробелы, но могут и отсутствовать.
//3. Имеется строка с текстом. Вывести текст, составленный из последних букв
//всех слов
//4.Напишите два цикла выполняющих многократное сложение строк, один
//с помощью оператора сложения и String, а другой с помощью StringBuilder
//и метода append. Сравните скорость их выполнения.
//5. Дана строка:
//" Hey      There!     How      Are you doing"   ;
//оставить лишь 1 пробел между слов.
//6. Написать regexp для email.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    static Pattern pattern = Pattern.compile("[,.?!]|[...]");
    static Pattern pattern1 = Pattern.compile("[a-zA-Z]+\\s*");
    static Pattern pattern2 = Pattern.compile("([a-zA-Z])[\\s|[,.!?]]");
    static Pattern pattern3 = Pattern.compile("[a-zA-Z]");
    static Pattern pattern4 = Pattern.compile("^([1-9]|0[1-9]|[1-2][0-9]|30)\\.([1-9]|0[1-9]|1[0-2])\\.(19[0-9]{2}|20[0-1][0-9]|202[0-1])$");

    //6
    static Pattern email = Pattern.compile("[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    public static void main(String[] args) {
        String str = "I, like java!!!";
        System.out.println(str);
        //1
        System.out.println("Количество знаков припенания: " + match(pattern,str));
        //2
        System.out.println("Количество слов в предложении: " + match(pattern1,str));
        //3
        Matcher matcher1 = pattern2.matcher(str);
        while (matcher1.find()){
           System.out.print(matcher1.group(1));
        }
        System.out.println();
        //test data format dd.mm.yyyy (days 1-30, years 1900-2021)
        Matcher matcher4 = pattern4.matcher(str);
        while (matcher4.find()){
            System.out.println("Year");
            System.out.println(matcher4.group(3));
        }
        //4
        //5
        String str1 = " Hey      There!     How      Are you doing";
        System.out.println(str1.strip().replaceAll(" +"," "));

    }
    public static int match(Pattern p,String s){
        Matcher matcher = p.matcher(s);
        int count = 0;
        while(matcher.find()){count++;}
        return count;
    }
}
