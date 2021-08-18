package by.academy.homework.hmwk5.task3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        Integer[][] test = new Integer[5][5];
        Integer[][] numb = {{},{11, 12, 13}, {}, {}, {18, 19, 20, 21, 22}, {1, 9, 0, 1, 22}, {}, {}};
        for (int i = 0; i < numb.length; i++) {
            for (int j = 0; j < numb[i].length; j++) {
                System.out.print(numb[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Iterator");
        TwoDimArrayIterator<Integer> iterator = new TwoDimArrayIterator(numb);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
