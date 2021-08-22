package by.academy.deal.services;

import by.academy.deal.services.exceptions.ParseException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TimeValidator {

    //date type dd/|-mm/|-yyyy where dd (01-31), mm (01-12), yyyy (1900-2999)
    static LocalDate dateLocal;

    public static boolean dateValidate(String str, String format, Pattern date) throws ParseException {
        Matcher match = date.matcher(str);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        boolean result = false;
        if (match.find()) {
            try {
                dateLocal = LocalDate.parse(str, formatter);
                result = true;
            } catch (DateTimeException e) {
                throw new ParseException("Parse Time Invalid");
            }
            if (LocalDate.now().isBefore(dateLocal)) {
                throw new ParseException("Parse Time Invalid");
            } else {
                result = true;
            }

        } else {
            throw new ParseException("Parse Time Invalid");
        }
        return result;
    }
}