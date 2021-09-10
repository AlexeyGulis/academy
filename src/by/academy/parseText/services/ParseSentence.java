package by.academy.parseText.services;

import by.academy.parseText.entity.Paragraph;
import by.academy.parseText.entity.Sentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSentence {
    public static final Pattern sentencePattern = Pattern.compile("(.*?[\\.|!|\\?])");

    public static void parseSentence(String str, Paragraph paragraph) {
        Matcher matcher = sentencePattern.matcher(str);
        Sentence sentence;
        while (matcher.find()) {
            sentence = new Sentence();
            ParseWord.parseWord(matcher.group(), sentence);
            paragraph.addSentence(sentence);
        }
    }
}
