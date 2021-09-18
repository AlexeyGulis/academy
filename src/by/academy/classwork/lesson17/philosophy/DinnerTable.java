package by.academy.classwork.lesson17.philosophy;

public class DinnerTable {
    public static void main(String[] args) {
        Object[] forks = new Object[5];
        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(forks[i],forks[(i+1) % forks.length]);
        }
        for (int i = 0; i < 5; i++) {
            new Thread(philosophers[i]).start();
        }
    }
}
