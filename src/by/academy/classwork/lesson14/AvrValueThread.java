package by.academy.classwork.lesson14;

public class AvrValueThread implements Runnable{
    public int[] values;
    public AvrValueThread(int[] values){
        this.values = values;
    }
    @Override
    public void run() {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            result+=i;
        }
        System.out.println(result/values.length);
    }
}
