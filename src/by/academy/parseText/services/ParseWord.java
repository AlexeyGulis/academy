package by.academy.parseText.services;

import by.academy.parseText.entity.PunctuationMarks;
import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.SimpleWord;
import by.academy.parseText.entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseWord {
    public static final Pattern wordPattern = Pattern.compile("(\\S+)");
    public static final Pattern punctuationMarkPattern = Pattern.compile("(\\S+)(\\.|\\?|!|,)");

    public static void parseWord(String str, Sentence sentence) {
        Matcher matcher = wordPattern.matcher(str);
        Matcher matcher1;
        while (matcher.find()) {
            matcher1 = punctuationMarkPattern.matcher(matcher.group());
            if (matcher1.matches()) {
                Word t = new SimpleWord(matcher1.group(1));
                Word t1 = new PunctuationMarks(matcher1.group(2));
                sentence.addWord(t);
                sentence.addWord(t1);
            } else {
                Word t = new SimpleWord(matcher.group());
                sentence.addWord(t);
            }
        }
    }
}
