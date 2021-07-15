package by.academy.classwork.lesson4;

public class Task12 {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 56;
        StringBuilder str = new StringBuilder();
        str.append(num1);
        str.append(" + ");
        str.append(num2);
        str.append(" = ");
        str.append(num1+num2);
        System.out.println(str);
        StringBuilder str1 = new StringBuilder();
        str1.append(num1);
        str1.append(" - ");
        str1.append(num2);
        str1.append(" = ");
        str1.append(num1-num2);
        System.out.println(str1);
        StringBuilder str2 = new StringBuilder();
        str2.append(num1);
        str2.append(" * ");
        str2.append(num2);
        str2.append(" = ");
        str2.append(num1*num2);
        System.out.println(str2);
    }
}
