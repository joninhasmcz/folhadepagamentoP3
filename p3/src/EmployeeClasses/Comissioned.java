package EmployeeClasses;

import java.util.ArrayList;
import PayrollClasses.Exceptions;

public class Comissioned extends Employee{

    public Comissioned(int employeeId, String name, String address, int type, int isSindicate, int paymentMethod, String scheduleType, int dayFrequency) {
        super(employeeId, name, address, type, isSindicate, paymentMethod, scheduleType, dayFrequency);
    }

    private double salaryComissionedFix;
    private double SalaryComissionedLiq;
    private double comissionValue;
    private double comission;

    @Override
    public void salary() {
        System.out.println("Digite o Salário:");
        System.out.println("Exemplo: xxxx,xx\nR$: ");

        double salaryTemp = Exceptions.readDouble();

        System.out.println("Digite aqui o percentual da Comissão: ");
        System.out.println("Exemplo: 15 para 15% 1.5 para 1.5%");

        this.comission = Exceptions.readDouble();
        this.salaryComissionedFix = salaryTemp;


    }

    @Override
    public void payEmployee(ArrayList<Employee> employee, int index) {
        this.SalaryComissionedLiq = salaryComissionedFix + comissionValue - getSindicate().getSindicateTax() - getSindicate().getServiceTaxValue();
        System.out.println(employee.get(index).toString() + "\n");

        this.SalaryComissionedLiq = 0;
        this.comissionValue = 0;

    }



    public void sellResult() {
        System.out.println("Dia da Venda:");
        int sellDay = Exceptions.readInt();

        System.out.println("Mês da Venda");
        int sellMonth = Exceptions.readInt();

        System.out.println("Ano da Venda");
        int sellYear = Exceptions.readInt();

        System.out.println("\nValor da Venda:\nPor exemplo: 1500 - 3000,56\nR$: ");
        double sellValue = Exceptions.readDouble();

        this.comissionValue = (sellValue * comission) / 100;

        System.out.println("\n===============================Registro de Venda=================================");
        System.out.println("Nome: " + getName() + "		Número do empregado: " + getEmployeeId());
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Data da venda: " + sellDay + "/ " + sellMonth + "/" + sellYear + "		Valor da comissão: R$ " + ((sellValue * comission) / 100));
        System.out.println("==================================================================================");

        System.out.println("\nResultado da venda do Empregado foi registrado com Sucesso!");
    }

    public double getSalaryComissionedFix() {
        return salaryComissionedFix;
    }

    public double getSalaryComissionedLiq() {
        return SalaryComissionedLiq;
    }

    public double getComission() {
        return comission;
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
            else if (getDayFrequency() == 4) dayString= "Quinta";
            else if (getDayFrequency() == 5) dayString = "Sexta";
            else if (getDayFrequency() == 6) dayString = "Sábado";
            else if (getDayFrequency() == 7) dayString = "Domingo";

            string += "Agenda de Pagamento: " + getScheduleType() + "	Dia da semana: " + dayString;
            string += "\n_________________________________________________________________________________________________________\n";

            if (getIsSindicate() == 1) {
                string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicate().getSindicateTax();
                string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicate().getServiceTaxValue();
            }

            string += "\nComissão de vendas -------------------------------------------------------- (+) R$ " + this.comissionValue;
            string += "\n\nSalário Líquido  -------------------------------------------------------------- R$ " + this.getSalaryComissionedLiq();

            return string;
        }


}

