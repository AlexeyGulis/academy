package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Word;

import java.util.List;

public class SearchUniqueWord {
    public static void searchWord(List<Sentence> sentenceList) {
        List<Word> wordList1stSentence = sentenceList.get(0).getWordList();
        boolean flag;
        for (Word t : wordList1stSentence
        ) {
            flag = true;
            for (int i = 1; i < sentenceList.size(); i++) {
                List<Word> tempList = sentenceList.get(i).getWordList();
                for (Word p : tempList
                ) {
                    if (t.toString().equalsIgnoreCase(p.toString())) {
                        flag = false;
                    }
                }

            }
            if(flag){
                System.out.println(t);
                break;
            }
        }
    }
}
