package by.academy.parseText.services;

import by.academy.parseText.entity.Paragraph;
import by.academy.parseText.entity.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseParagraph {
    public static final Pattern paragraphPattern = Pattern.compile(".*?\\n");

    public static void parsePattern(String str, Text text) {
        Matcher matcher = paragraphPattern.matcher(str);
        Paragraph paragraph;
        while (matcher.find()) {
            paragraph = new Paragraph();
            ParseSentence.parseSentence(matcher.group(), paragraph);
            text.addParagraph(paragraph);
        }
    }
}
