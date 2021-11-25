package by.academy.algorithms.sorts;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSort {

    public static void merge(int[] array, int[] arrayCopy, int low, int mid, int high) {
        for (int i = low; i < high; i++) {
            arrayCopy[i] = array[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k < high; k++) {
            if (i > mid) array[k] = arrayCopy[j++];
            else if (j > high) array[k] = arrayCopy[i++];
            else if (arrayCopy[j] < arrayCopy[i]) array[k] = arrayCopy[j++];
            else array[k] = arrayCopy[i++];
        }


    }

    public static void sort(int[] array, int[] arrayCopy, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(array, arrayCopy, low, mid);
        sort(array, arrayCopy, mid + 1, high);
        merge(array, arrayCopy, low, mid, high);
    }

    public static void sort(int[] array) {
        int[] arrayCopy = new int[array.length];
        sort(array, arrayCopy, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int N = 100_000_000;
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
    }
}
