package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.SimpleWord;
import by.academy.parseText.entity.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedWordsVowelsToConsonants {
    public static void sort(List<Word> wordList) {
        Collections.sort(wordList, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int vowels1 = o1.getWord().replaceAll("[^aeyuioAEYUIOяуаеиоэюёыЫЮЕЁЭЯУАЕИО]", "").length();
                int vowels2 = o2.getWord().replaceAll("[^aeyuioAEYUIOяуаеиоэюёыЫЮЕЁЭЯУАЕИО]", "").length();
                return (double) vowels1 / (double) o1.getWord().length() < (double) vowels2 / (double) o2.getWord().length() ?
                1 : (double) vowels1 / (double) o1.getWord().length() > (double) vowels2 / (double) o2.getWord().length() ? -1 : 0;
            }
        });
        for (Word t : wordList
        ) {
            if(t instanceof SimpleWord){
                System.out.println(t);
            }
        }
    }
}
