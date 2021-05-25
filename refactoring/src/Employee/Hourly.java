package Employee;

import java.util.ArrayList;

import System.Exceptions;

public class Hourly extends Employee {

    public Hourly (int numberEmployee, String name, String address, int type, int paymentMethod, int isSindicate, String scheduleType, int dayWeek) {
        super(numberEmployee, name, address, type, paymentMethod, isSindicate, scheduleType, dayWeek);
    }

    private double salaryHourlyLiq = 0;
    private double salaryHourly = 0;
    private double salaryHour = 0;

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    @Override
    public void entranceSalary() {
        System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1,5 - 3\nR$ ");

        double salaryTemp = Exceptions.readDouble();

        this.salaryHour = salaryTemp;

    }

    @Override
    public void payEmployee(ArrayList<Employee> employee, int index) {

        this.salaryHourlyLiq = salaryHourly - getSindicate().getSindicalTax()
                - getSindicate().getValueServiceTax();
        System.out.println(employee.get(index).toString() + "\n");

        this.salaryHourlyLiq = 0;
        this.salaryHourly = 0;

    }

    // GETTERS AND SETTERS


    public double getSalaryHourlyLiq() {
        return salaryHourlyLiq;
    }

    public void setSalaryHourlyLiq(double salaryHourlyLiq) {
        this.salaryHourlyLiq = salaryHourlyLiq;
    }

    public double getSalaryHourly() {
        return salaryHourly;
    }

    public void setSalaryHourly(double salaryHourly) {
        this.salaryHourly = salaryHourly;
    }

    public double getSalaryHour() {
        return salaryHour;
    }

    public void setSalaryHour(double salaryHour) {
        this.salaryHour = salaryHour;
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
        else if (getDayFrequency() == 5) dayString = "Sexta";
        else if (getDayFrequency() == 6) dayString = "Sábado";
        else if (getDayFrequency() == 7) dayString = "Domingo";

        string += "Agenda de Pagamento: " + this.getScheduleType() + "	Dia da semana: " + dayString;
        string += "\n________________________________________________________________________________________________________\n";

        if (getIsSindicate() == 1) {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicate().getSindicalTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicate().getValueServiceTax();
        }

        string += "\nSalário  Bruto Acumulado -------------------------------------------------- (+) R$ " + this.salaryHourly;
        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salaryHourlyLiq;

        return string;
    }
}
