package by.academy.classwork.lesson10;

public class ExceptionFinally {
    public static void procA() throws RuntimeException{
        try{
            System.out.println("Внутри procA");
            throw new RuntimeException("demo");
        }finally{
            System.out.println("procA finally");
        }
    }
    public static void procB(){
        try{
            System.out.println("Внутри procB");
            return;
        }finally{
            System.out.println("procB finally");
        }
    }
    public static void main(String[] args) {
        try{
            //procA();
            procB();
        }catch(RuntimeException e) {
            System.out.println("Исключение выброшено");
        }
    }
}
