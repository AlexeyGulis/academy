package by.academy.classwork.lesson6;

public class Magazine implements Printable{
    @Override
    public void print() {
        System.out.println("Магазин");
    }
    public static void printMagazines(Printable[] print){
        for (Printable a:print
        ) {
            if(a!=null && a instanceof Magazine){
                System.out.println("Магазин");
            }
        }
    }
}
