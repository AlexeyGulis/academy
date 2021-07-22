package by.academy.homework.hmwk3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidator {
    //date type dd.mm.yyyy where dd (01-31), mm (01-12), yyyy (1900-2021)
    static Pattern date = Pattern.compile("^([1-9]|0[1-9]|[12][0-9]|3[01])[./]([1-9]|0[1-9]|1[0-2])[./](19[0-9]{2}|20[01][0-9]|202[0-1])$");
    public static boolean dateValidate(String str){
        Matcher match = date.matcher(str);
        if(match.find()){
            if(Integer.valueOf(match.group(2))!=2 && Integer.valueOf(match.group(2))%2==0 && Integer.valueOf(match.group(1))==31){
                return false;
            } else if(Integer.valueOf(match.group(2))==2 && Integer.valueOf(match.group(1))>28){
                return false;
            }
            return true;
        } else return false;
    }
}
