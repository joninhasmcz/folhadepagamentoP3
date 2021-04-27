package PayrollClasses;

public class PaymentCalendar {
    private int dayWeek = 1;
    private int day = 1;
    private int week = 1;
    private int month = 1;
    private int year = 2021;
    private String dayString = "Segunda";


    public void advanceDay() {
        this.day++;
        this.dayWeek++;
        this.week = (day / 7) + 1;

        if (dayWeek == 8) {
            this.dayWeek = 1;
        }

        if (this.month == 2 & this.day == 29) {
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

    public int getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(int dayWeek) {
        this.dayWeek = dayWeek;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
