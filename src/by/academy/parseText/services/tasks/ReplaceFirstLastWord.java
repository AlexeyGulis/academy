package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.List;

public class ReplaceFirstLastWord {
    public static void replace(List<Sentence> sentenceList) {
        for (Sentence s : sentenceList
        ) {
            List<Word> wordList = s.getWordList();
            Word temp = wordList.get(wordList.size() - 2);
            wordList.set(wordList.size() - 2, wordList.get(0));
            wordList.set(0, temp);
            s.setWordList(wordList);
        }
    }
}
