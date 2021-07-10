package by.academy.lesson3;

public class While {
    public static void main(String[] args) {
        int n = 5;
        while (n > 0) {
            System.out.println("Тик " + n--);
        }
        System.out.println("End while");
        do{
            System.out.println("Так " + n++);
        }while(n<=10);
        System.out.println("End do-while");
    }
}
