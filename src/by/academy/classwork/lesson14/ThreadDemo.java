package by.academy.classwork.lesson14;

public class ThreadDemo {
    public static void main(String[] args) {
        Runnable interfThread = new ThreadFromRunnable();
        Thread newThread5 = new Thread(interfThread);
        newThread5.start();
        FromThread newThread1 = new FromThread("A");
        FromThread newThread2 = new FromThread("B");
        FromThread newThread3 = new FromThread("C");
        newThread1.start();
        newThread2.start();
        try{
            newThread2.join();
        }catch(InterruptedException e){e.getMessage();}
        newThread3.start();
        System.out.println("Hello");
    }
}
