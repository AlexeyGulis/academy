package by.academy.classwork.lesson14;

import java.util.Arrays;

public class MinValueThread implements Runnable{
    public int[] values;
    public MinValueThread(int[] values){
        this.values = values;
    }
    @Override
    public void run() {
        System.out.println(Arrays.stream(values).max());
    }
}
