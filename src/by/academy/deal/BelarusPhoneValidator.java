package by.academy.deal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {
    static Pattern phoneBLR = Pattern.compile("^\\+375-\\d{2}-\\d{3}-\\d{2}-\\d{2}$");

    public boolean validate(String t) {
        Matcher matcher = phoneBLR.matcher(t);
        boolean result;
        if (matcher.find()) {
            System.out.println("Телефонный номер из Беларуси");
            result = true;
        } else {
            System.out.println("Телефонный номер не из Беларуси");
            result = false;
        }
        return result;
    }
}
