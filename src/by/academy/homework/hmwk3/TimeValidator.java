package by.academy.homework.hmwk3;

import java.text.ParseException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeValidator {
    //date type dd/|-mm/|-yyyy where dd (01-31), mm (01-12), yyyy (1900-2999)
    static Pattern date1 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|2[0-9][0-9][0-9])$");
    static Pattern date2 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
    public static boolean dateValidate(String str) throws ParseException{
        Matcher match1 = date1.matcher(str);
        Matcher match2 = date2.matcher(str);
        StringBuilder strB = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        if(match1.find()){
            if(Integer.valueOf(match1.group(2))!=2 && Integer.valueOf(match1.group(2))%2==0 && Integer.valueOf(match1.group(1))==31){
                return false;
            } else if(Integer.valueOf(match1.group(2))==2 && Integer.valueOf(match1.group(1))>28){
                return false;
            } else {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(match1.group());
                if(new Date().before(date)){return false;} else {
                    calendar.setTime(date);
                    strB.append("Day: <").append(calendar.get(Calendar.DAY_OF_MONTH)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Month: <").append(calendar.get(Calendar.MONTH)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Year: <").append(calendar.get(Calendar.YEAR)).append("> ");
                    System.out.println(strB);
                }
            }
            return true;
        } else if(match2.find()){
            if(Integer.valueOf(match2.group(2))!=2 && Integer.valueOf(match2.group(2))%2==0 && Integer.valueOf(match2.group(1))==31){
                return false;
            } else if(Integer.valueOf(match2.group(2))==2 && Integer.valueOf(match2.group(1))>28){
                return false;
            } else {
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(match2.group());
                if(new Date().before(date)){return false;} else {
                    calendar.setTime(date);
                    strB.append("Day: <").append(calendar.get(Calendar.DAY_OF_MONTH)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Month: <").append(calendar.get(Calendar.MONTH)).append("> ");
                    System.out.println(strB);
                    strB.setLength(0);
                    strB.append("Year: <").append(calendar.get(Calendar.YEAR)).append("> ");
                    System.out.println(strB);
                }
            }
            return true;
        } else return false;
    }
}
