package by.academy.parseText.logic;

import by.academy.parseText.ParseTextDemo;
import by.academy.parseText.entity.Text;
import by.academy.parseText.services.ParseParagraph;
import by.academy.parseText.services.ReadFile;
import by.academy.parseText.services.tasks.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogicParse {

    public void logicParse(Text text) {
        try {
            ParseTextDemo.parseText = LogicParse.readFile();
        } catch (IOException e) {
            e.getMessage();
        }
        parseText(text, ParseTextDemo.parseText);
        System.out.println("Text from Objects");
        System.out.println(text);
        System.out.println("Words: " + text.getCountWords());
        System.out.println("Sentences: " + text.getCountSentence());
        System.out.println("Paragraphs: " + text.getCountParagraph());
        task1(text);
        //task2(text);
        //task3(text);
        //task4(text,6);
        //task5(text);
        //task6(text);
        //task7(text);
        //task8(text);
        //task9(text, 'а');
        //task10(text);
        //task11(text,'о', 'о');
        //task12(text,6);
        //task13(text,'а');
        //task14(text);
        //task15(text);
        //task16(text,8);
        System.out.println();
        System.out.println("Text from Task");
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
    public static void task1(Text text){
        CountSentenceWithDuplicate.search(text.getTextSentenceList());
    }
    public static void task2(Text text) {
        SortSentenceByCountWords.sortSentence(text);
    }

    public static void task3(Text text) {
        SearchUniqueWord.searchWord(text.getTextSentenceList());
    }

    public static void task4(Text text, int size) {
        InterrogativeSentence.searchInterrogativeSentence(text.getTextSentenceList(), size);
    }

    public static void task5(Text text){
        ReplaceFirstLastWord.replace(text.getTextSentenceList());
    }

    public static void task6(Text text) {
        SortTextWordsAlphabet.sortTextWordsByAlphabet(text.getTextWordsList());
    }

    public static void task7(Text text) {
        SortedWordsVowelsToConsonants.sort(text.getTextWordsList());
    }

    public static void task8(Text text) {
        SortConsonantsLetter.sort(text.getTextWordsList());
    }

    public static void task9(Text text, char letter) {
        SortCountLetter.sort(text.getTextWordsList(), letter);
    }
    public static void task10(Text text){
        Map<String,Integer> wordList = new HashMap<>();
        wordList.put("реализации", 0);
        wordList.put("что", 0);
        wordList.put("структуры", 0);
        SortListWord.sort(text.getTextSentenceList(),wordList);
    }
    public static void task11(Text text, char start, char end){
        RemoveSubString.remove(text.getTextSentenceList(),start,end);
    }
    public static void task12(Text text,int length){
        RemoveWords.remove(text.getTextSentenceList(),length);
    }
    public static void task13(Text text,char ch){
        SortWordCountChar.sort(text.getTextWordsList(),ch);
    }
    public static void task14(Text text){
        SearchMaxLengthPalindrome.search(text);
    }
    public static void task15(Text text){
        TransformWord.transformWithoutFirstChar(text.getTextWordsList());
        //TransformWord.transformWithoutLastChar(text.getTextWordsList());
    }
    public static void task16(Text text, int length){
        ReplaceWordWithSubString.replace(text.getTextSentenceList(),length);
    }
}
