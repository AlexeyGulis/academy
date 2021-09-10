package by.academy.parseText.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphList = new ArrayList<>();
    public void addParagraph(Paragraph t){
        paragraphList.add(t);
    }
    public int getCountParagraph(){
        return paragraphList.size();
    }
    public int getCountSentence(){
        int result = 0;
        for (Paragraph t:paragraphList
             ) {
            result+= t.getCountSentence();
        }
        return result;
    }
    public int getCountWords(){
        int result = 0;
        for (Paragraph t:paragraphList
        ) {
            result+= t.getCountWords();
        }
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (Paragraph t: paragraphList
             ) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}
