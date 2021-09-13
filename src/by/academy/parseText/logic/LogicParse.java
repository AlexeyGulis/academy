package by.academy.parseText.logic;

import by.academy.parseText.ParseTextDemo;
import by.academy.parseText.entity.Sentence;
import by.academy.parseText.entity.Text;
import by.academy.parseText.services.ParseParagraph;
import by.academy.parseText.services.ReadFile;
import by.academy.parseText.services.tasks.SearchUniqueWord;
import by.academy.parseText.services.tasks.SortSentenceByCountWords;

import java.io.IOException;

public class LogicParse {

    public void logicParse(Text text){
        try {
           ParseTextDemo.parseText = LogicParse.readFile();
        } catch (IOException e) {
            e.getMessage();
        }
        parseText(text, ParseTextDemo.parseText);
        System.out.println("Words: " + text.getCountWords());
        System.out.println("Sentences: " + text.getCountSentence());
        System.out.println("Paragraphs: " + text.getCountParagraph());
        //task2(text);
        task3(text);
        System.out.println();
        System.out.println("Text from Objects");
        System.out.println(text);
    }

    public static String readFile() throws IOException {
        if (ReadFile.checkPath() && ReadFile.checkFile()) {
            return ReadFile.getText();
        } else {
            return null;
        }
    }

    public static void parseText(Text text, String parseText) {
        if (parseText != null) {
            ParseParagraph.parsePattern(parseText, text);
        }
    }
    public static void task2(Text text){
        SortSentenceByCountWords.sortSentence(text);
    }
    public static void task3(Text text){
        SearchUniqueWord.searchWord(text.getTextSentenceList());
    }
}