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
    public int compare(Object ob1,Object ob2){
        Integer o1 = ((Sentence) ob1).getCountWords();
        Integer o2 = ((Sentence) ob2).getCountWords();
        if(o1<o2){
            return 1;
        }if(o1>o2){
            return -1;
        }else return 0;
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
