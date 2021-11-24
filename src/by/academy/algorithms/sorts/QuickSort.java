package by.academy.algorithms.sorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort<T> {

    public static int partition(int[] a, int i, int j) {
        if (i >= j) return i;
        int temp;
        int low = i;
        while (true) {
            while (a[low] <= a[j] ) {
                if(j == i) break;
                j--;
            }
            while (a[low] >= a[i]) {
                if(i == j) break;
                i++;
            }
            if (i >= j) break;
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
        temp = a[low];
        a[low] = a[i];
        a[i] = temp;
        return i;
    }

    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int i, int j) {
        if (i >= j) return;
        int low = partition(a, i, j);
        sort(a, i, low - 1);
        sort(a, low + 1, j);
    }

    public static void main(String[] args) {
        int N = 2000000;
        int[] a = new int[N];
        long t1;
        long t2;
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(255);
        }
        t1 = System.nanoTime();
        QuickSort.sort(a);
        t2 = System.nanoTime();
        StdOut.println(t2-t1);
        for (int i = 0; i < N - 1; i++) {
            if(a[i]>a[i+1]){
                StdOut.println("not sorted");
            }
        }
    }
}
