package by.academy.algorithms.sorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort<T> {

    public static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        int temp;
        while (true){
            while(a[++i] < a[low]){
                if(i == high) break;
            }
            while(a[--j] > a[low]){
                if(j == low) break;
            }
            if(i>=j)break;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
    }

    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    public static void main(String[] args) {
        int N = 50000000;
        int[] a = new int[N];
        long t1;
        long t2;
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(255);
        }
        t1 = System.nanoTime();
        MergeSort.sort(a);
        t2 = System.nanoTime();
        StdOut.println(t2 - t1);
        t1 = System.nanoTime();
        QuickSort.sort(a);
        t2 = System.nanoTime();
        StdOut.println(t2 - t1);
        t1 = System.nanoTime();
        Way3QuickSort.sort(a);
        t2 = System.nanoTime();
        StdOut.println(t2 - t1);
        for (int i = 0; i < N - 1; i++) {
            if (a[i] > a[i + 1]) {
                StdOut.println("not sorted");
            }
        }

    }
}
