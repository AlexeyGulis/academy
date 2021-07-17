package by.academy.classwork.lesson5;
//Изменить регулярное выражение в примере для нахождения строк cab, ccab, cccab.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("cab");
        Pattern pattern1 = Pattern.compile("ccab");
        Pattern pattern2 = Pattern.compile("cccab");
        Matcher matcher = pattern.matcher("aacab");
        boolean b = matcher.matches();
        boolean a1 = matcher.find();
        boolean a2 = matcher.find();
        boolean a3 = matcher.find();

        System.out.println(b);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

    }
}