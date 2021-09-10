package by.academy.parseText;

import by.academy.parseText.entity.*;
import by.academy.parseText.logic.LogicParse;
import by.academy.parseText.services.ReadFile;

import java.io.IOException;

public class ParseTextDemo {
    public static void main(String[] args) {
        String parseText = null;
        Text text = new Text();
        try {
            parseText = LogicParse.readFile();
        } catch (IOException e) {
            e.getMessage();
        }
        LogicParse.parseText(text, parseText);
        System.out.println("Words: " + text.getCountWords());
        System.out.println("Sentences: " + text.getCountSentence());
        System.out.println("Paragraphs: " + text.getCountParagraph());
        System.out.println(text);
    }
}
