package by.academy.classwork.lesson6;

public class Application {
    public static void main(String[] args) {
        Printable[] print = new Printable[5];
        print[0] = new Book();
        print[1] = new Magazine();
        print[2] = new Magazine();
        print[3] = new Book();
        print[4] = new Book();
        for (Printable a : print
        ) {
            a.print();
        }
        Magazine.printMagazines(print);
        Book.printBooks(print);
    }
}
