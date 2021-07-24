package by.academy.homework.hmwk3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {
    static Pattern phoneUSA = Pattern.compile("^\\+1\\d{7}$");

    public boolean validate(String t) {
        Matcher matcher = phoneUSA.matcher(t);
        if (matcher.find()) {
            System.out.println("Phone number from USA");
            return true;
        } else {
            System.out.println("Phone number not from USA");
            return false;
        }
    }
}
