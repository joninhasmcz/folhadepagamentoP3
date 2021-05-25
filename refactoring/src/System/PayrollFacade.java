package System;

import Company.AddEmployee;
import Employee.TimeCard;
import Employee.SellResult;
import Company.Schedule;
import Company.PlayPayroll;

public class PayrollFacade {

    private DatabaseSingleton database;
    private AddEmployee addEmployee;
    private TimeCard timeCard;
    private SellResult sellResult;
    private PlayPayroll playPayroll;
    private Schedule schedule;

    public PayrollFacade() {
        this.database = DatabaseSingleton.getInstance();
        this.addEmployee = new AddEmployee();
        this.timeCard = new TimeCard();
        this.sellResult = new SellResult();
        this.playPayroll = new PlayPayroll();
        this.schedule = new Schedule();
    }

    public void add() {
        addEmployee.add();
    }

    public void remove() {
        database.removeEmployee();
    }

    public void timeCard() {
        timeCard.playTimeCard();
    }

    public void sell() {
        sellResult.playSellResult();
    }

    public void serviceTax() {
        int index = database.searchEmployee();
        if (index == -1) return;

        if (database.getEmployeeArrayList().get(index).getIsSindicate() == 1) {
            database.getEmployeeArrayList().get(index).getSindicate().serviceTax();
        }
        else {
            System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
        }
    }

    public void edit() {
        int index = database.searchEmployee();
        if (index == -1) return;

        database.getEmployeeArrayList().get(index).alterDetails();
    }

    public void play(int day, int dayWeek, int week, int last) {
        playPayroll.playPayroll(day, dayWeek, week, last);
    }

    public void paymentSchedule() {
        schedule.consultSchedule();
    }

    public void newSchedule() {
        schedule.newScedule();
    }

}
