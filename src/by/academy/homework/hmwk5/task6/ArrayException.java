package by.academy.homework.hmwk5.task6;

public class ArrayException {
    public static void main(String[] args) {
        int[] arrayInt = new int[8];
        try {
            for (int i = 0; i < 10; i++) {
                arrayInt[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is too small. Please expend array");
        }
    }
}
