package Employee;

import System.DatabaseSingleton;
import System.Exceptions;

public class TimeCard {

    private DatabaseSingleton database = DatabaseSingleton.getInstance();
    private Hourly hourly;

    public boolean verifyHourly() {

        int index = database.searchEmployee();
        if (index == -1) return false;

        if (database.getEmployeeArrayList().get(index) instanceof Hourly) {
            hourly = (Hourly) database.getEmployeeArrayList().get(index);

            return true;
        }

        else return false;
    }

    public void playTimeCard() {

        if (verifyHourly() == true) {

            System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
            int timeCardE = Exceptions.readInt();

            System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
            int timeCardS = Exceptions.readInt();

            // Calcula o salário
            double salaryHourly = hourly.getSalaryHourly() + (calculateSalary(hourly.getSalaryHour(), timeCardE, timeCardS));

            hourly.setSalaryHourly(salaryHourly);

            System.out.println("\nCartão de Ponto registrado com sucesso!\n");

        } else {System.out.println("\nErro: Empregado não é Horista.\n");}
    }


    public double calculateSalary (double salaryHour, int entrance, int exit) {
        double salary;

        int workHour = exit - entrance;
        float minutes = workHour % 100;

        if (workHour <= 800) {

            if (minutes < 10) {
                minutes = minutes / 10;
            } else {
                minutes = minutes / 100;
            }

            salary = ((workHour / 100) * salaryHour) + (minutes * workHour);
        } else {
            int extraHour = workHour - 800;

            if (minutes < 10) {
                minutes = minutes / 10;
            } else {
                minutes = minutes / 100;
            }

            salary = (8 * salaryHour + ((extraHour / 100) * (salaryHour * 1.5)) + (minutes * (extraHour * 1.5)));

        }

        return salary;
    }


}
