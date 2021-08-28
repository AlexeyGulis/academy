package by.academy.classwork.lesson11;

public class Task9{
    static void print(){
        System.out.println("Something");
    }
    public static void main(String[] args) {
        Printable pr = Task9::print;
        pr.print();
    }
}