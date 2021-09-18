package by.academy.classwork.lesson17.philosophy;

import by.academy.classwork.lesson17.ObjectThread;

public class Philosopher extends Thread{
    private Object leftfork;
    private Object rightfork;
    public Philosopher(Object leftfork,Object rightfork){
        super();
        this.leftfork = leftfork;
        this.rightfork = rightfork;
    }
    private void doAction(String action){

    }
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("1");
            synchronized (leftfork){
                System.out.println("2");
            }
            synchronized (rightfork){
                System.out.println("3");
            }
        }
    }
}
