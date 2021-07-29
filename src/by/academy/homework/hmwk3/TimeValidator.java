package by.academy.homework.hmwk3;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeValidator {
    //ПЕРЕДЕЛАТЬ
    //date type dd/|-mm/|-yyyy where dd (01-31), mm (01-12), yyyy (1900-2999)
    static Pattern date1 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static Pattern date2 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");

    public static boolean dateValidate(String str){
        Matcher match1 = date1.matcher(str);
        Matcher match2 = date2.matcher(str);
        StringBuilder strB = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        boolean result = false;
        boolean flag;
        Date date;
        if (match1.find()) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try{
                dateFormat.parse(match1.group());
                flag = true;
            }
            catch(ParseException e){
                System.out.println("Incorrect date");
                return false;
            }
            if (flag) {
                try{
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(match1.group());
                }catch(ParseException e){
                    return false;
                }
                if (new Date().before(date)) {
                    System.out.println("Incorrect date");
                    result = false;
                } else {
                    // SimpleDateFormat вывод Day: <> Month: <> Year: <>
                    calendar.setTime(date);
                    strB.append("Day: <").append(calendar.get(Calendar.DAY_OF_MONTH)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Month: <").append((calendar.get(Calendar.MONTH)+1)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Year: <").append(calendar.get(Calendar.YEAR)).append("> ");
                    System.out.println(strB);
                    result = true;
                }
            } else {
                result = flag;
            }
        } else if (match2.find()) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try{
                dateFormat.parse(match2.group());
                flag = true;
            }
            catch(ParseException e){
                System.out.println("Incorrect date");
                return false;
            }
            if (flag) {
                try{
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(match2.group());
                }catch(ParseException e){
                    return false;
                }
                if (new Date().before(date)) {
                    System.out.println("Incorrect date");
                    result = false;
                } else {
                    // SimpleDateFormat вывод Day: <> Month: <> Year: <>
                    calendar.setTime(date);
                    strB.append("Day: <").append(calendar.get(Calendar.DAY_OF_MONTH)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Month: <").append((calendar.get(Calendar.MONTH)+1)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Year: <").append(calendar.get(Calendar.YEAR)).append("> ");
                    System.out.println(strB);
                    result = true;
                }
            } else {
                result = flag;
            }
        }
        return result;
    }
}
