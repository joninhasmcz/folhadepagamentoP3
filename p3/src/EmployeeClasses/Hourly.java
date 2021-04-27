package EmployeeClasses;

import java.util.ArrayList;
import PayrollClasses.Exceptions;

public class Hourly extends Employee{

    public Hourly(int employeeId, String name, String address, int type, int isSindicate, int paymentMethod, String scheduleType, int dayFrequency) {
        super(employeeId, name, address, type, isSindicate, paymentMethod, scheduleType, dayFrequency);
    }

    private double salaryHourlyLiq = 0;
    private double salaryHourly = 0;
    private double salaryHour = 0;

    @Override
    public void salary() {
        System.out.println("Digite o salário por hora Trabalhada:\nExemplo: X,X ou X\nR$: ");
        double salaryTemp = Exceptions.readDouble();

        this.salaryHour = salaryTemp;
    }

    @Override
    public void payEmployee(ArrayList<Employee> employee, int index) {
        this.salaryHourlyLiq = salaryHourly - getSindicate().getSindicateTax() - getSindicate().getServiceTaxValue();
        System.out.println(employee.get(index).toString() + "\n");

        this.salaryHourlyLiq = 0;
        this.salaryHourly = 0;
    }

    public void timeCard() {
        System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
        int timeCardEntrance = Exceptions.readInt();

        System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
        int timeCardExit = Exceptions.readInt();

        System.out.println("Cartão de Ponto do Empregado resgitrado com Sucesso!\n");
    }

    public static double calculateSalary(double salaryHour, int entrance, int exit) {
        double salary;

        int workHour = exit - entrance;
        float minutes = workHour % 100;

        if(workHour <= 800) {
            if(minutes < 10) {
                minutes = minutes / 10;
            } else {
                minutes = minutes / 100;
            }

            salary = ((workHour/100) * salaryHour) + (minutes * salaryHour);

        }
        else {
            int extraHour = workHour - 800;

            if(minutes < 10) {
                minutes = minutes / 10;
            } else {
                minutes = minutes / 100;
            }

            salary = (8 * salaryHour + ((extraHour/100) * (salaryHour * 1.5)) + (minutes * (extraHour * 1.5)));
        }
        return salary;
    }

    public double getSalaryHourly() {
        return salaryHourly;
    }

    @Override
    public String toString() {
        String string, dayString = null;

        string = super.toString();

        string += "Tipo: Horista		Salário Hora: R$ " + this.salaryHour;
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (getDayFrequency() == 1) dayString = "Segunda";
        else if (getDayFrequency() == 2) dayString = "Terça";
        else if (getDayFrequency() == 3) dayString = "Quarta";
        else if (getDayFrequency() == 4) dayString = "Quinta";
        else if (getDayFrequency() == 5) dayString= "Sexta";
        else if (getDayFrequency() == 6) dayString = "Sábado";
        else if (getDayFrequency() == 7) dayString = "Domingo";

        string += "Agenda de Pagamento: " + this.getScheduleType() + "	Dia da semana: " + dayString;
        string += "\n________________________________________________________________________________________________________\n";

        if (getIsSindicate() == 1) {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicate().getSindicateTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicate().getServiceTaxValue();
        }

        string += "\nSalário  Bruto Acumulado -------------------------------------------------- (+) R$ " + this.salaryHourly;
        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salaryHourlyLiq;

        return string;
    }
}
