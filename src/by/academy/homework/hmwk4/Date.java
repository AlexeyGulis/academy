package by.academy.homework.hmwk4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
    private String date;
    static Pattern dateP = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
    Year y;
    Month m;
    Day d;

    Date(String date) {
        if (validateDate(date)) {
            this.date = date;
            String[] nk = date.split("-");
            d = new Day(Integer.valueOf(nk[0]));
            m = new Month(Integer.valueOf(nk[1]));
            y = new Year(Integer.valueOf(nk[2]));

        } else {
            this.date = "Date invalid";
        }
    }

    class Year {
        private int year;

        Year(int year) {
            this.year = year;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }

    class Month {
        private int month;

        Month(int month) {
            this.month = month;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }
    }

    class Day {
        private int day;

        Day(int day) {
            this.day = day;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }

    enum DayOfWeek {
        Sunday(1), Monday(2), Tuesday(3), Wednesday(4), Thursday(5), Friday(6), Saturday(7);
        int dayOfWeek;

        DayOfWeek(int d) {
            this.dayOfWeek = d;
        }

        int getDayOfWeek() {
            return dayOfWeek;
        }
    }


    public void setDate(String date) {
        if (validateDate(date)) {
            this.date = date;
            String[] nk = date.split("-");
            d.setDay(Integer.valueOf(nk[0]));
            m.setMonth(Integer.valueOf(nk[1]));
            y.setYear(Integer.valueOf(nk[2]));

        } else {
            this.date = "Date invalid";
        }
    }

    public void getDayOfWeek() throws ParseException {
        Calendar calendar = new GregorianCalendar();
        java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(this.date);
        calendar.setTime(date);
        for (DayOfWeek a : DayOfWeek.values()) {
            //if(calendar.get(Calendar.DAY_OF_WEEK)==(a.ordinal()+1)){
            //    System.out.println(a);
            //}
            if (calendar.get(Calendar.DAY_OF_WEEK) == a.getDayOfWeek()) {
                System.out.println(a);
            }
        }
    }

    public static boolean validateDate(String date) {
        Matcher match = dateP.matcher(date);
        boolean result = false;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        if (match.find()) {
            try {
                dateFormat.parse(match.group());
                System.out.println("Date valid");
                result = true;
            } catch (Exception e) {
                System.out.println("Date invalid");
                result = false;
            }
        } else {
            System.out.println("Date invalid");
            result = false;
        }
        return result;
    }

    public void getDateInDays() {
        int result = 0;
        for (int j = 1; j < y.getYear(); j++) {
            if (isLeapYear(j)) {
                result += 366;
            } else {
                result += 365;
            }
        }
        for (int i = 1; i < m.getMonth(); i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                result += 30;
            } else if (i == 2) {
                if (isLeapYear(y.getYear())) {
                    result += 29;
                } else {
                    result += 28;
                }
            } else {
                result+=31;
            }
        }
        result+=d.getDay()-1;
        System.out.println("Days start from 01.01.0001  =  " + result);
    }

    public String getDate() {
        return date;
    }

    public static boolean isLeapYear(int y) {
        boolean result;
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0) {
                    result = true;
                } else {
                    result = false;
                }
            } else {
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }
}

