package by.academy.parseText.logic;

import by.academy.parseText.entity.Text;
import by.academy.parseText.services.ParseParagraph;
import by.academy.parseText.services.ReadFile;

import java.io.IOException;

public class LogicParse {

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
}
