package Employee;

import java.util.ArrayList;
import System.Exceptions;

public class Salaried extends Employee {
    public Salaried (int numberEmployee, String name, String address, int type, int paymentMethod, int isSindicate, String scheduleType, int dayWeek) {
        super(numberEmployee, name, address, type, paymentMethod, isSindicate, scheduleType, dayWeek);
    }

    // SALARY

    private double salarySalariedFix;
    private double salarySalariedLiq;

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    @Override
    public void entranceSalary() {
        System.out.print("\nInforme o salário fixo mensal:\nExemplo: 1500 - 3000,56\nR$ ");

        double salaryTemp = Exceptions.readDouble();

        this.salarySalariedFix = salaryTemp;
    }

    @Override
    public void payEmployee(ArrayList<Employee> employee, int index) {
        this.salarySalariedLiq = salarySalariedFix - getSindicate().getSindicalTax() - getSindicate().getValueServiceTax();
        System.out.println(employee.get(index).toString() + "\n");

        this.salarySalariedLiq = 0;
    }

    // GETTERS AND SETTERS


    public double getSalarySalariedFix() {
        return salarySalariedFix;
    }

    public double getSalarySalariedLiq() {
        return salarySalariedLiq;
    }

    @Override
    public String toString() {
        String string;

        string = super.toString();

        string += "Tipo: Assalariado		Salário Bruto: R$ " + this.salarySalariedFix;
        string += "\n--------------------------------------------------------------------------------------------------------\n";
        string += "Agenda de Pagamento: " + this.getScheduleType() + "	Dia: " + this.getDayFrequency();
        string += "\n________________________________________________________________________________________________________\n\n";

        if (getIsSindicate() == 1) {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicate().getSindicalTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicate().getValueServiceTax();
        }

        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarySalariedLiq;

        return string;
    }
}
