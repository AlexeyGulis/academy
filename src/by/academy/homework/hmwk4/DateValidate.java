package by.academy.homework.hmwk4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidate {
    public boolean validate(String date) {
        String format = "dd-MM-yyyy";
        Pattern dateP = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        Matcher match = dateP.matcher(date);
        boolean result = false;
        LocalDate dateLocal;
        if (match.find()) {
            try {
                dateLocal = LocalDate.parse(date, formatter);
                result = true;
            } catch (DateTimeException e) {
                return false;
            }

        } else {
            result = false;
        }
        return result;
    }
}
