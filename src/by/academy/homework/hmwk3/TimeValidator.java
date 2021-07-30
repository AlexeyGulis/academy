package by.academy.homework.hmwk3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TimeValidator {

    //date type dd/|-mm/|-yyyy where dd (01-31), mm (01-12), yyyy (1900-2999)
    static LocalDate dateLocal;

    public static boolean dateValidate(String str, String format, Pattern date) {
        Matcher match = date.matcher(str);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        boolean result = false;
        if (match.find()) {
            try {
                dateLocal = LocalDate.parse(str, formatter);
                result = true;
            } catch (DateTimeException e) {
                return false;
            }
            if (LocalDate.now().isBefore(dateLocal)) {
                result = false;
            } else {
                result = true;
            }

        } else {
            result = false;
        }
        return result;
    }
}