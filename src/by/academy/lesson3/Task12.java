package by.academy.lesson3;
//Создать двумерный массив из 6 строк по 7 столбцов в каждой из случайных целых чисел из отрезка [0;9]. Вывести массив на экран.
//Преобразовать массив таким образом, чтобы на первом месте в каждой строке стоял её наибольший элемент.
//При этом изменять состав массива нельзя, а можно только переставлять элементы в рамках одной строки.
//Порядок остальных элементов строки не важен (т.е. можно соврешить только одну перестановку, а можно отсортировать по убыванию каждую строку).
//Вывести преобразованный массив на экран.
import java.util.Random;
public class Task12 {
    public static void main(String[] args) {
        int[][] array = new int[6][7];
        Random rand = new Random();
        for (int i = 0; i<6;i++) {
            for (int j = 0; j<7;j++) {
                array[i][j] = rand.nextInt(9);
            }
        }
        for (int[] a1 : array
        ) {
            for (int i : a1
            ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("первый элемент наибольший");
        int max_index = 0;
        int max = 0;
        for (int i = 0; i<6;i++) {
            for (int j = 0; j<7;j++) {
                if (array[i][j] >max){
                    max = array[i][j];
                    max_index = j;
                }
            }
            int temp = 0;
            temp = array[i][0];
            array[i][0] = array[i][max_index];
            array[i][max_index] = temp;
        }
        for (int[] a1 : array
        ) {
            for (int i : a1
            ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
