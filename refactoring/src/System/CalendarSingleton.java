package System;

public class CalendarSingleton {

    private static CalendarSingleton uniqueInstance;

    public static synchronized CalendarSingleton getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new CalendarSingleton();
        }
        return uniqueInstance;
    }

    private int dayWeek;
    private int day ;
    private int week;
    private int month;
    private int year;
    private String dayString;

    private CalendarSingleton() {
        this.day = 1;
        this.month = 1;
        this.year = 2019;
        this.dayWeek = 1;
        this.week = 1;
        this.dayString = "Segunda";
    }

    public void advanceDay() {
        this.day++;
        this.dayWeek++;
        this.week = (day / 7) + 1;

        if(dayWeek == 8) {
            this.dayWeek = 1;
        }

        if(this.month == 2 && this.day == 29) {
            this.day = 1;
            this.week = 1;
            this.month++;
        }

        if (this.day == 32) {
            if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
                if (this.month == 12) {
                    this.day = 1;
                    this.week = 1;
                    this.month = 1;
                    this.year++;
                } else {
                    this.day = 1;
                    this.week = 1;
                    this.month++;
                }
            }
        } else if (this.day == 31) {
            if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
                this.day = 1;
                this.week = 1;
                this.month++;
            }
        }

        if (dayWeek == 1) dayString = "Segunda";
        else if (dayWeek == 2) dayString = "Terça";
        else if (dayWeek == 3) dayString = "Quarta";
        else if (dayWeek == 4) dayString = "Quinta";
        else if (dayWeek == 5) dayString = "Sexta";
        else if (dayWeek == 6) dayString = "Sábado";
        else if (dayWeek == 7) dayString = "Domingo";

    }

    public int lastDay(int month) {
        int last = 0;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            last = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            last = 30;
        } else if (month == 2) {
            last = 28;
        }

        return last;
    }

    @Override
    public String toString() {

        return this.dayString + " - Dia: " + this.day + " Mês: " + this.month + " Ano: " + this.year;
    }

    // GETTERS AND SETTERS


    public int getDayWeek() {
        return dayWeek;
    }

    public int getDay() {
        return day;
    }

    public int getWeek() {
        return week;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
