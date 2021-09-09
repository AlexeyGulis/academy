package by.academy.classwork.lesson14;

import java.util.Arrays;

public class MaxValueThread implements Runnable{
    public int[] values;
    public MaxValueThread(int[] values){
        this.values = values;
    }
    @Override
    public void run() {
        System.out.println(Arrays.stream(values).min());
    }
}
