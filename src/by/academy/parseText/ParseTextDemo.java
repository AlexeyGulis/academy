package by.academy.parseText;

import by.academy.parseText.entity.*;
import by.academy.parseText.logic.LogicParse;
import by.academy.parseText.services.ReadFile;

import java.io.IOException;

public class ParseTextDemo {
    public static String parseText = null;
    public static void main(String[] args) {
        Text text = new Text();
        LogicParse logic = new LogicParse();
        logic.logicParse(text);
    }
}
