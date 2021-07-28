package by.academy.homework.hmwk4;

import java.util.Scanner;

public class Date {
    int year;
    int month;
    int day;
    Scanner scan = new Scanner(System.in);

    class Year{
        void getYear(){

        }
    }
    class Month{
        void getMonth(){

        }
    }
    class Day{
        void getDay(){

        }
    }
    enum DayOfWeek{
        Monthday(1),Thuesday(2),Satarday(3),Friday(4),Forteday(5),Sunday(6),Wethday(7);
        private int day;
        DayOfWeek(int day){
            this.day = day;
        }
    }

    public static void setDate(){

    }
    public static void main(String[] args) {

    }
}
