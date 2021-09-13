package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Text;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortSentenceByCountWords {
    public static void sortSentence(Text text) {
        List<Sentence> sentenceList = text.getTextSentenceList();
        Collections.sort(sentenceList,new CountWordsComporator());
        for (Sentence t: sentenceList
             ) {
            System.out.println(t);
        }
    }
}

class CountWordsComporator implements Comparator<Sentence> {
    @Override
    public int compare(Sentence o1, Sentence o2) {
        return o1.getCountWords() < o2.getCountWords() ? -1 : o1.getCountWords() > o2.getCountWords() ? 1 : 0;
    }
}
