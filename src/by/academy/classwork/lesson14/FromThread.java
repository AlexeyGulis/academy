package by.academy.classwork.lesson14;

public class FromThread extends Thread {
    public String name;

    public FromThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println("Thread " + name + ": " + i);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
