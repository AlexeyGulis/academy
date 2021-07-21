package by.academy.homework.hmwk3;

import java.util.regex.Pattern;

public class SimpleDateFormat {
    static Pattern day = Pattern.compile("0[1-9]|[1-2][0-9]|30");
    static Pattern month = Pattern.compile("[,.?!]|[...]");
    static Pattern year = Pattern.compile("[,.?!]|[...]");
    //date type dd.mm.yyyy where dd (01-30), mm (01-12), yyyy (1900-2021)
    static Pattern date1 = Pattern.compile("0[1-9]\\.0[1-9]\\.19[0-9]{2}|0[1-9]\\.0[1-9]\\.20[0-1][0-9]|0[1-9]\\.0[1-9]\\.202[0-1]|[1-2][0-9]\\.0[1-9]\\.19[0-9]{2}|[1-2][0-9]\\.0[1-9]\\.20[0-1][0-9]|[1-2][0-9]\\.0[1-9]\\.202[0-1]|30\\.0[1-9]\\.19[0-9]{2}|30\\.0[1-9]\\.20[0-1][0-9]|30\\.0[1-9]\\.202[0-1]|0[1-9]\\.1[0-2]\\.19[0-9]{2}|0[1-9]\\.1[0-2]\\.20[0-1][0-9]|0[1-9]\\.1[0-2]\\.202[0-1]|[1-2][0-9]\\.1[0-2]\\.19[0-9]{2}|[1-2][0-9]\\.1[0-2]\\.20[0-1][0-9]|[1-2][0-9]\\.1[0-2]\\.202[0-1]|30\\.1[0-2]\\.19[0-9]{2}|30\\.1[0-2]\\.20[0-1][0-9]|30\\.1[0-2]\\.202[0-1]");
    static Pattern email = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]");
    public static boolean parsec(){
        return true;
    }
}
