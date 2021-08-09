package by.academy.homework.hmwk4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private String date;
    private String format = "dd-MM-yyyy";
    private DateTimeFormatter formatter;
    private LocalDate localDate;
    protected Year year;
    protected Month month;
    protected Day day;

    public Date() {
        formatter = DateTimeFormatter.ofPattern(format);
        localDate = LocalDate.now();
        day = new Day(localDate.getDayOfMonth());
        month = new Month(localDate.getMonthValue());
        year = new Year(localDate.getYear());
    }

    public Date(String date) {
        formatter = DateTimeFormatter.ofPattern(format);
        this.date = date;
        localDate = LocalDate.parse(date, formatter);
        day = new Day(localDate.getDayOfMonth());
        month = new Month(localDate.getMonthValue());
        year = new Year(localDate.getYear());
    }

    private class Year {
        private int year;

        public Year(int year) {
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Year year1 = (Year) o;

            return year == year1.year;
        }

        @Override
        public int hashCode() {
            return year;
        }

        @Override
        public String toString() {
            return "Year{" +
                    "year=" + year +
                    '}';
        }
    }

    private class Month {
        private int month;

        public Month(int month) {
            this.month = month;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Month month1 = (Month) o;

            return month == month1.month;
        }

        @Override
        public int hashCode() {
            return month;
        }

        @Override
        public String toString() {
            return "Month{" +
                    "month=" + month +
                    '}';
        }
    }

    private class Day {
        private int day;

        public Day(int day) {
            this.day = day;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Day day1 = (Day) o;

            return day == day1.day;
        }

        @Override
        public int hashCode() {
            return day;
        }

        @Override
        public String toString() {
            return "Day{" +
                    "day=" + day +
                    '}';
        }
    }

    public enum DayOfWeek {
        Sunday(7), Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6);
        public int dayOfWeek;

        DayOfWeek(int d) {
            this.dayOfWeek = d;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }
    }


    public void setDate(String date) {
        this.date = date;
        localDate = LocalDate.parse(date, formatter);
        day.day = localDate.getDayOfMonth();
        month.month = localDate.getMonthValue();
        year.year = localDate.getYear();

    }

    public void getDayOfWeek() {
        for (DayOfWeek a : DayOfWeek.values()) {
            if (localDate.getDayOfWeek().getValue() == a.getDayOfWeek()) {
                System.out.println(a);
            }
        }
    }

    public void getDaysBetweenDates(Date date) {
        int days = 0;
        LocalDate temp;
        temp = getLocalDate().plusDays(days);
        if (getLocalDate().isBefore(date.getLocalDate())) {
            while (true) {
                if (temp.isEqual(date.getLocalDate())) {
                    break;
                } else {
                    temp = getLocalDate().plusDays(++days);
                }
            }
        } else {
            while (true) {
                if (temp.isEqual(date.getLocalDate())) {
                    break;
                } else {
                    temp = getLocalDate().minusDays(++days);
                }
            }
        }
        System.out.println("Days between " + getLocalDate().format(formatter) + " and " + date.getLocalDate().format(formatter) + " = " + days);
    }

    public String getDate() {
        return date;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public boolean isLeapYear() {
        return localDate.isLeapYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date1 = (Date) o;

        if (date != null ? !date.equals(date1.date) : date1.date != null) return false;
        if (localDate != null ? !localDate.equals(date1.localDate) : date1.localDate != null) return false;
        if (year != null ? !year.equals(date1.year) : date1.year != null) return false;
        if (month != null ? !month.equals(date1.month) : date1.month != null) return false;
        return day != null ? day.equals(date1.day) : date1.day == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (localDate != null ? localDate.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "localDate=" + getLocalDate().format(formatter) +
                '}';
    }
}

