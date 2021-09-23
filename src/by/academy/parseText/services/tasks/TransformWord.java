package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.SimpleWord;
import by.academy.parseText.entity.Word;

import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class TransformWord {
    public static void transformWithoutFirstChar(List<Word> wordList){
        for (Word t : wordList
             ) {
            if(t instanceof SimpleWord){
                String str = t.getWord().toLowerCase(Locale.ROOT);
                String result = str.replace(String.valueOf(str.charAt(0)),"");
                t.setWord(result);
            }
        }
    }

    public static void transformWithoutLastChar(List<Word> wordList){
        for (Word t : wordList
        ) {
            if(t instanceof SimpleWord){
                String str = t.getWord().toLowerCase(Locale.ROOT);
                String result = str.replace(String.valueOf(str.charAt(str.length()-1)),"");
                t.setWord(result);
            }
        }
    }
}
