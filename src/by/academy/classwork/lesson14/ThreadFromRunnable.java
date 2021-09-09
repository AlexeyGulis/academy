package by.academy.classwork.lesson14;

public class ThreadFromRunnable implements Runnable {
    @Override
    public void run() {
        boolean flag1 = true;
        for (int i = 0; i < 100; i++) {
            System.out.println("Runnable : i");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
