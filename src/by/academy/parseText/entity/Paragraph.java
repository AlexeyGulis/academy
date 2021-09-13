package by.academy.parseText.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentenceList = new ArrayList<>();

    public void addSentence(Sentence t) {
        sentenceList.add(t);
    }

    public int getCountSentence() {
        return sentenceList.size();
    }

    public List<Sentence> getSentenceList(){
        return sentenceList;
    }

    public int getCountWords() {
        int result = 0;
        for (Sentence t : sentenceList) {
            result += t.getCountWords();
        }
        return result;
    }

    public List<Word> getWordsList() {
        List<Word> wordList = new ArrayList<>();
        for (Sentence t : sentenceList
        ) {
            wordList.addAll(t.getWordList());
        }
        return wordList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (Sentence t : sentenceList
        ) {
            sb.append(t.toString());
        }
        return sb.toString();
    }
}
