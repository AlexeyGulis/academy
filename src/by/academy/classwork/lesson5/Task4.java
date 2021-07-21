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
    static Pattern pattern2 = Pattern.compile("[a-zA-Z][\\s|[,.!?]]");
    static Pattern pattern3 = Pattern.compile("[a-zA-Z]");
    //6
    static Pattern email = Pattern.compile("[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    public static void main(String[] args) {
        String str = "I,Like java.!!...";
        System.out.println(str);
        //1
        System.out.println("Количество знаков припенания: " + match(pattern,str));
        //2
        System.out.println("Количество слов в предложении: " + match(pattern1,str));
        //3
        Matcher matcher1 = pattern2.matcher(str);
        while (matcher1.find()){
            Matcher matcher3 = pattern3.matcher(matcher1.group());
            while (matcher3.find()){System.out.print(matcher3.group());}
        }
        System.out.println();
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
