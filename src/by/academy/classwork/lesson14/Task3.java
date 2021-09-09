package by.academy.classwork.lesson14;

public class Task3 {


    public static void main(String[] args) {
        int[] val = {1,23,4,45,61,12,3,-1,23,-4,332,13,570,100};
        Thread thread1 = new Thread(new MinValueThread(val));
        Thread thread2 = new Thread(new MaxValueThread(val));
        Thread thread3 = new Thread(new AvrValueThread(val));
        thread1.start();
        try {
            thread1.join();
        }catch (InterruptedException e){
            e.getMessage();
        }
        thread2.start();

        try {
            thread2.join();
        }catch (InterruptedException e){
            e.getMessage();
        }
        thread3.start();

        try {
            thread3.join();
        }catch (InterruptedException e){
            e.getMessage();
        }
        System.out.println("Закончили выполнение в главном потоке");
    }
}
