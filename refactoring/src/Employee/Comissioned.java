package Employee;

import java.util.ArrayList;

import System.Exceptions;

public class Comissioned extends Employee{

    public Comissioned(int numberEmployee, String name, String address, int type, int paymentMethod, int isSindicate, String scheduleType, int dayWeek) {
        super(numberEmployee, name, address, type, paymentMethod, isSindicate, scheduleType, dayWeek);
    }

    private double salaryComissionedFix;
    private double salaryComissionedLiq;
    private double comissionValue;
    private double comission;

   // PADRÃO DE PROJETO : TEMPLATE METHOD

    @Override
    public void entranceSalary() {
        System.out.print("\nInforme o salário:\nExemplo: 1500 - 3000,56\nR$ ");
        double salaryTemp = Exceptions.readDouble();

        System.out.println("\nInforme o percentual de comissão:\nExemplo: 15 para 15% 1.5 para 1.5%");
        this.comission = Exceptions.readDouble();

        this.salaryComissionedFix = salaryTemp;

    }

    @Override
    public void payEmployee(ArrayList<Employee> employee, int index) {
        this.salaryComissionedLiq = salaryComissionedFix + comissionValue - getSindicate().getSindicalTax() - getSindicate().getValueServiceTax();
        System.out.println(employee.get(index).toString() + "\n");

        this.salaryComissionedLiq = 0;
        this.comissionValue = 0;
    }

    // GETTERS AND SETTERS

    public double getSalaryComissionedFix() {
        return salaryComissionedFix;
    }

    public double getSalaryComissionedLiq() {
        return salaryComissionedLiq;
    }

    public double getComission() {
        return comission;
    }

    public double getComissionValue() {
        return comissionValue;
    }

    public void setComissionValue(double comissionValue) {
        this.comissionValue = comissionValue;
    }

    @Override
    public String toString() {
        String string, dayString = null;

        string = super.toString();

        string += "Tipo: Comissionado		Salário Bruto: R$ " + this.salaryComissionedFix + "	Comissão: " + this.comission + "%";
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (getDayFrequency() == 1) dayString = "Segunda";
        else if (getDayFrequency() == 2) dayString = "Terça";
        else if (getDayFrequency() == 3) dayString = "Quarta";
        else if (getDayFrequency() == 4) dayString = "Quinta";
        else if (getDayFrequency() == 5) dayString = "Sexta";
        else if (getDayFrequency() == 6) dayString = "Sábado";
        else if (getDayFrequency() == 7) dayString = "Domingo";

        string += "Agenda de Pagamento: " + getScheduleType() + "	Dia da semana: " + dayString;
        string += "\n_________________________________________________________________________________________________________\n";

        if (getIsSindicate() == 1) {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicate().getSindicalTax();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicate().getValueServiceTax();
        }

        string += "\nComissão de vendas -------------------------------------------------------- (+) R$ " + this.comissionValue;
        string += "\n\nSalário Líquido  -------------------------------------------------------------- R$ " + this.salaryComissionedLiq;

        return string;
    }



}
