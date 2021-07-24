package by.academy.homework.hmwk3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {
    static Pattern phoneBLR = Pattern.compile("^\\+375\\d{7}$");

    public boolean validate(String t) {
        Matcher matcher = phoneBLR.matcher(t);
        if (matcher.find()) {
            System.out.println("Phone number from BLR");
            return true;
        } else {
            System.out.println("Phone number not from BLR");
            return false;
        }
    }
}
