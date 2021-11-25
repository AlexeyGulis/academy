package by.academy.algorithms.sorts;

import edu.princeton.cs.algs4.StdRandom;

public class Way3QuickSort {
    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) return;
        int lt = low;
        int ht = high;
        int i = lt;
        int temp = a[low];
        while (i <= ht) {
            if (a[i] < temp) exch(a, lt++, i++);
            else if (a[i] > temp) exch(a, i, ht--);
            else i++;
        }
        sort(a, low, lt - 1);
        sort(a, ht + 1, high);
    }
}
