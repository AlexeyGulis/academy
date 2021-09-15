package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.SimpleWord;
import by.academy.parseText.entity.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTextWordsAlphabet {
    public static void sortTextWordsByAlphabet(List<Word> wordList) {
        Collections.sort(wordList, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getWord(), o2.getWord());
                if (res == 0) {
                    res = o1.getWord().compareTo(o2.getWord());
                }
                return res;
            }
        });
        String prevLetter = "";
        for (Word t : wordList
        ) {
            if (t instanceof SimpleWord){
                if(!prevLetter.equalsIgnoreCase(String.valueOf(t.getWord().charAt(0)))){
                    prevLetter = String.valueOf(t.getWord().charAt(0));
                    System.out.println();
                }
                System.out.println(t);
            }
        }
    }
}
