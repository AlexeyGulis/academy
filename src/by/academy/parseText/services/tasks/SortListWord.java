package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortListWord {
    public static void sort(List<Sentence> sentenceList, Map<String, Integer> wordList) {
        for (Sentence s : sentenceList
        ) {
            List<Word> wordsList = s.getWordList();
            for (Word t : wordsList
            ) {
                if (wordList.containsKey(t.getWord())) {
                    wordList.put(t.getWord(), wordList.get(t.getWord()) + 1);
                }
            }
            Collections.sort(wordsList, new Comparator<Word>() {
                @Override
                public int compare(Word o1, Word o2) {
                    int i1 = 0;
                    int i2 = 0;
                    if (wordList.containsKey(o1.getWord())) {
                        i1 = wordList.get(o1.getWord());
                    }
                    if (wordList.containsKey(o2.getWord())) {
                        i2 = wordList.get(o2.getWord());
                    }
                    return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
                }
            });
            s.setWordList(wordsList);
        }

    }
}
