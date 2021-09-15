package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.SimpleWord;
import by.academy.parseText.entity.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCountLetter {
    public static void sort(List<Word> wordList, char letter) {
        Collections.sort(wordList, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord().replaceAll("[^" + letter + "]", "").length() > o2.getWord().replaceAll("[^" + letter + "]", "").length()
                        ? 1 : o1.getWord().replaceAll("[^" + letter + "]", "").length() < o2.getWord().replaceAll("[^" + letter + "]", "").length()
                        ? -1 : o1.getWord().compareToIgnoreCase(o2.getWord());
            }
        });
        for (Word t : wordList
        ) {
            if (t instanceof SimpleWord) System.out.println(t);
        }
    }
}
