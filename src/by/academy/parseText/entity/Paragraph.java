package by.academy.parseText.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph{
    private List<Sentence> sentenceList = new ArrayList<>();
    public void addSentence(Sentence t){
        sentenceList.add(t);
    }
    public int getCountSentence(){return sentenceList.size();}
    public int getCountWords(){
        int result = 0;
        for (Sentence t : sentenceList){
            result+= t.getCountWords();
        }
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (Sentence t: sentenceList
             ) {
            sb.append(t.toString());
        }
        return sb.toString();
    }
}
