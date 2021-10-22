package by.academy.algorithms.sorts;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    static int[] buf;
    static int count = 0;

    public static void mergeSort(int array[], int low, int high) {
        if (high > low) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            buf = Arrays.copyOf(array, array.length);
            int i = low, j = mid + 1;
            for (int k = low; k <= high; k++) {
                if(i > mid){
                    array[k]=buf[j];
                    j++;
                    count++;
                }else if(j > high){
                    array[k]=buf[i];
                    i++;
                    count++;
                }else if(buf[i] > buf[j]){
                    array[k] = buf[j];
                    j++;
                    count++;
                }else {
                    array[k] = buf[i];
                    i++;
                    count++;
                }
            }

        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[] m1;
        Random rand = new Random();
        m1 = new int[10000];
        for (int i = 0; i < m1.length; i++) {
            m1[i] = rand.nextInt(100);
        }
        buf = new int[m1.length];
        System.out.println("Sort array: ");
        System.out.println(Arrays.toString(m1));
        mergeSort(m1, 0, m1.length - 1);
        System.out.println("Res");
        System.out.println(Arrays.toString(m1));
        System.out.println("Count = " + count);
    }
}
