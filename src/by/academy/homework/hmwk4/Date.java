package by.academy.homework.hmwk4;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
    private String date;
    String format;
    DateTimeFormatter formatter;
    Pattern dateP;
    LocalDate localDate;
    Year y;
    Month m;
    Day d;

    Date() {
        String format = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        dateP = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
        localDate = LocalDate.now();
        d = new Day(localDate.getDayOfMonth());
        m = new Month(localDate.getMonthValue());
        y = new Year(localDate.getYear());
    }

    Date(String date) {
        format = "dd-MM-yyyy";
        formatter = DateTimeFormatter.ofPattern(format);
        dateP = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9]{2}|2[0-9][0-9][0-9])$");
        if (validateDate(date)) {
            this.date = date;
            localDate = LocalDate.parse(date, formatter);
            d = new Day(localDate.getDayOfMonth());
            m = new Month(localDate.getMonthValue());
            y = new Year(localDate.getYear());
        } else {
            this.date = "Date invalid";
        }
    }

    Date(String date, String format, Pattern pattern) {
        this.date = date;
        this.format = format;
        this.formatter = DateTimeFormatter.ofPattern(format);
        this.dateP = pattern;
        if (validateDate(date)) {
            localDate = LocalDate.parse(date, formatter);
            d = new Day(localDate.getDayOfMonth());
            m = new Month(localDate.getMonthValue());
            y = new Year(localDate.getYear());
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
        Sunday(7), Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6);
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
            localDate = LocalDate.parse(date, formatter);
            d = new Day(localDate.getDayOfMonth());
            m = new Month(localDate.getMonthValue());
            y = new Year(localDate.getYear());

        } else {
            this.date = "Date invalid";
        }
    }

    public void getDayOfWeekE() {
        for (DayOfWeek a : DayOfWeek.values()) {
            if (localDate.getDayOfWeek().getValue() == a.getDayOfWeek()) {
                System.out.println(a);
            }
        }
    }

    public boolean validateDate(String date) {
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

    public void getDateInDays(Date obj) {
        int days = 0;
        LocalDate temp;
        temp = getLocalDate().plusDays(days);
        if (getLocalDate().isBefore(obj.getLocalDate())) {
            while (true) {
                if (temp.isEqual(obj.getLocalDate())) {
                    break;
                } else {
                    temp = getLocalDate().plusDays(++days);
                }
            }
        } else {
            while (true) {
                if (temp.isEqual(obj.getLocalDate())) {
                    break;
                } else {
                    temp = getLocalDate().minusDays(++days);
                }
            }
        }
        System.out.println("Days between " + getLocalDate().format(formatter) + " and " + obj.getLocalDate().format(formatter) + " = " + days);
    }

    public String getDate() {
        return date;
    }

    public LocalDate getLocalDate() {
        return localDate;
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

