package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.List;

public class SearchUniqueWord {
    public static void searchWord(List<Sentence> sentenceList){
        List<Word> wordList1stSentence = sentenceList.get(0).getWordList();
        for (Word t: wordList1stSentence
             ) {
            for (int i = 1; i < sentenceList.size(); i++) {
                List<Word> tempList = sentenceList.get(i).getWordList();
                for (Word p: tempList
                     ) {
                    if(t.equals(p)){
                        continue;
                    }
                }
                System.out.println(t);
                return;
            }
            System.out.println(t);
            return;
        }
    }
}
