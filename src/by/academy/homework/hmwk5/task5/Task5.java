package by.academy.homework.hmwk5.task5;

import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        String text = "I like java!!";
        char[] chars = text.toCharArray();
        int[] freq = new int[128];
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i]]++;
        }
        Map<Character, Integer> freqChar = new HashMap<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                freqChar.put((char) i, freq[i]);
            }
        }
        freqChar.forEach((k, v) -> System.out.println(k + " в количестве " + v));
    }
}
