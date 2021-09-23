package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.SimpleWord;
import by.academy.parseText.entity.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWordCountChar {
    public static void sort(List<Word> wordList, char ch) {
        Collections.sort(wordList, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int count1 = countChar(o1, ch);
                int count2 = countChar(o2, ch);
                return count1 > count2 ? -1 : count1 < count2 ? 1 : o1.getWord().compareTo(o2.getWord());
            }

            public int countChar(Word word, char ch) {
                int i = 0;
                int count = 0;
                while (word.getWord().indexOf(ch, i) != -1) {
                    count++;
                    i = word.getWord().indexOf(ch, i) + 1;
                }
                return count;
            }
        });
        for (Word t : wordList
        ) {
            if (t instanceof SimpleWord) System.out.println(t.getWord());
        }
    }
}
