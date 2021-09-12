package by.academy.parseText.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> wordList = new ArrayList<>();

    public void addWord(Word t) {
        wordList.add(t);
    }

    public int getCountWords() {
        return wordList.size();
    }

    public List<Word> getWordList() {
        return wordList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (Word t : wordList
        ) {
            sb.append(t.toString());
        }
        return sb.toString();
    }
}
