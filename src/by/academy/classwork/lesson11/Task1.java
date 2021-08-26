package by.academy.classwork.lesson11;

interface Printable{
    void print();
}

public class Task1 {
    public static void main(String[] args) {
        Printable print = () -> {
            System.out.println("hello world");
        };
        print.print();
    }
}
