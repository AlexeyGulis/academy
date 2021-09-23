package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class RemoveWords {
    public static void remove(List<Sentence> sentenceList, int length){
        String vowels = "aeyuioAEYUIOяуаеиоэюёыЫЮЕЁЭЯУАЕИО";
        List<Word> newWordList = new ArrayList<>();
        for (Sentence s : sentenceList
             ) {
            List<Word> wordList = s.getWordList();
            for (Word t : wordList
                 ) {
                if(vowels.indexOf(t.getWord().charAt(0))==-1){
                    newWordList.add(t);
                }else{
                    if(t.getWord().length() != length){
                        newWordList.add(t);
                    }
                }
            }
            s.setWordList(newWordList);
            newWordList = new ArrayList<>();
        }
    }
}
