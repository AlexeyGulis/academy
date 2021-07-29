package by.academy.classwork.lesson6;

public class Book implements Printable{
    public void print(){
        System.out.println("Книга");
    }
    public static void printBooks(Printable[] print){
        for (Printable a:print
             ) {
            if(a!=null && a instanceof Book){
                System.out.println("Книга");
            }
        }
    }
}
