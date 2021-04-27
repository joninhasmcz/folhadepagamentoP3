package EmployeeClasses;

import java.util.ArrayList;
import PayrollClasses.Exceptions;

public class Salaried extends Employee {

    public Salaried(int employeeId, String name, String address, int type, int isSindicate, int paymentMethod, String scheduleType, int dayFrequency) {
        super(employeeId, name, address, type, isSindicate, paymentMethod, scheduleType, dayFrequency);
    }

    private double salarySalariedFix;
    private double salarySalariedLiq;

    @Override
    public void salary() {
        System.out.println("Digite o salário fixo mensal:\nEmxemplo: 1500 - 2043,23\nR$: ");
        double salaryTemp = Exceptions.readDouble();

        this.salarySalariedFix = salaryTemp;

    }

    @Override
    public void payEmployee(ArrayList<Employee> employee, int index) {
        this.salarySalariedLiq = salarySalariedFix - getSindicate().getSindicateTax() - getSindicate().getServiceTaxValue();
        System.out.println(employee.get(index).toString() + "\n");

        this.salarySalariedLiq = 0;

    }

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
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicate().getSindicateTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicate().getServiceTaxValue();
        }

        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarySalariedLiq;

        return string;
    }



}
