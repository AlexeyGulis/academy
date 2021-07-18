package by.academy.homework.hmwk2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество слов: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите слова: ");
        String[] strs = new String[count];
        int result = -10;
        int min = 0;
        for (int i = 0; i < count; i++) {
            strs[i] = scanner.nextLine();
            char[] ch = strs[i].toCharArray();
            int t = 0;
            for (int j = 0; j < ch.length; j++) {
                t++;
                for (int k = 0; k < ch.length; k++) {
                    if(ch[j]==ch[k] && j!=k){
                        t--;
                        break;
                    }
                }
            }
            if(result==-10){
                result = t;
            }else if(result>t){
                result = t;
                min=i;
            }
        }
        System.out.println("Слово с минимальным количеством неповторяющихся символов -> " + strs[min]);
    }
}
