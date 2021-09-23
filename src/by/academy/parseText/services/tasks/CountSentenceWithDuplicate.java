package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountSentenceWithDuplicate {
    public static void search(List<Sentence> sentenceList){
        int count = 0;
        for (Sentence s : sentenceList
             ) {
            List<Word> wordList = s.getWordList();
            Set<Word> wordSetNoDupl = new HashSet<>(wordList);
            if(wordList.size() != wordSetNoDupl.size()){
                count++;
            }
        }
        System.out.println("Count of sentences with duplicate words: " + count);
    }
}
