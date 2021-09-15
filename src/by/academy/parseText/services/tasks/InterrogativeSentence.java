package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterrogativeSentence {
    public static void searchInterrogativeSentence(List<Sentence> sentenceList,int size){
        List<Word> wordList;
        Set<String> words = new HashSet<>();
        for (Sentence t : sentenceList
             ) {
            wordList = t.getWordList();
            if(wordList.size()!= 0 && wordList.get(wordList.size()-1).getWord().equals("?")){
                for (Word temp : wordList
                     ) {
                    if(temp.getWord().length() == size){
                        words.add(temp.getWord());
                    }
                }
                for (String s: words
                     ) {
                    System.out.println(s);
                }
            }
        }
    }
}
