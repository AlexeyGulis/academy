package by.academy.homework.hmwk5.task5;

import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        String text = "11122334444456vvvvvvvvv";
        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        char[] chars = text.toCharArray();
        Map<Character, Integer> freqChar = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (freqChar.get(chars[i]) == null) {
                freqChar.put(chars[i], 1);
            } else {
                freqChar.put(chars[i], freqChar.get(chars[i]) + 1);
            }
        }
        freqChar.forEach((k, v) -> System.out.print(k + " в количестве " + v + "; "));
    }
}
