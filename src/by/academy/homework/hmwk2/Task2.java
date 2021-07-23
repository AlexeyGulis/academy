package by.academy.homework.hmwk2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        while (true) {
            System.out.print("Введите количество слов: ");
            count = scanner.nextInt();
            scanner.nextLine();
            if (count > 0) {
                break;
            }
            System.out.println("Введено некоректное значение");
        }
        System.out.println("Введите слова: ");
        String[] strs = new String[count];
        int[] arrTemp;
        int countLetterMin = -10;
        int indexMin = 0;
        for (int i = 0; i < count; i++) {
            strs[i] = scanner.nextLine();
            char[] ch = strs[i].toCharArray();
            arrTemp = new int[ch.length];
            for (int j = 0; j < ch.length; j++) {
                arrTemp[j] = 0;
            }
            int countLetter = 0;
            for (int j = 0; j < ch.length; j++) {
                if (arrTemp[j] == 0) {
                    countLetter++;
                    for (int k = 0; k < ch.length; k++) {
                        if (ch[j] == ch[k] && arrTemp[k] == 0) {
                            arrTemp[k] = 1;
                        }
                    }
                }
            }
            if (countLetterMin == -10) {
                countLetterMin = countLetter;
                indexMin = i;
            } else if (countLetterMin > countLetter) {
                countLetterMin = countLetter;
                indexMin = i;
            }
        }
        scanner.close();
        System.out.println("Слово с минимальным количеством различных символов -> " + strs[indexMin]);
    }
}
