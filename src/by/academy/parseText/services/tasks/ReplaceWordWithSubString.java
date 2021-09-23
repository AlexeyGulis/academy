package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.List;
import java.util.Random;

public class ReplaceWordWithSubString {
    public static void replace(List<Sentence> sentenceList, int length){
        String sub = "asdfasdfasdczxcv";
        Random rand = new Random();
        //rand.nextInt(sentenceList.size())
        Sentence s = sentenceList.get(rand.nextInt(sentenceList.size()));
        List<Word> wordList = s.getWordList();
        for (Word t : wordList
             ) {
            if(t.getWord().length() == length){
                t.setWord(sub);
            }
        }
    }
}
