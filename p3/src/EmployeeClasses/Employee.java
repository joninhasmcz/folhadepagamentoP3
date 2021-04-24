package EmployeeClasses;

import java.util.ArrayList;
import java.util.Scanner;
import PayrollClasses.Exceptions;

public abstract class Employee {
    private int employeeId;
    private String name;
    private String address;
    private int type;
    private int isSindicate = 0;
    private int paymentMethod;

    // Variaveis da Agenda
    private String scheduleType;
    private int dayFrequency;

    Sindicate sindicate = new Sindicate();
    static Scanner input = new Scanner(System.in);

    public Employee(int employeeId, String name, String address, int type, int isSindicate, int paymentMethod, String scheduleType, int dayFrequency) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.type = type;
        this.isSindicate = isSindicate;
        this.paymentMethod = paymentMethod;
        this.scheduleType = scheduleType;
        this.dayFrequency = dayFrequency;
    }

    public void editDetails(int op) {
        switch(op) {
            case 1:
                System.out.println("Digite por favor o novo nome do Empregado");
                String name = input.nextLine();
                setName(name);
                System.out.println("Nome do Empregado alterado com sucesso!");

            case 2:
                System.out.println("Digite por favor o novo Endereço do Empregado");
                String address = input.nextLine();
                setAddress(address);
                System.out.println("Endereço do Empregado alterado com sucesso!");

            case 3:
                System.out.println("Método de Pagamento:");
                System.out.println("(1) Cheque pelos Correios");
                System.out.println("(2) Cheque em Mãos");
                System.out.println("(3) Depósito em Conta");

                int paymentMethod = Exceptions.readInt();
                setPaymentMethod(paymentMethod);

                System.out.println("Método de Pagamento do Empregado alterado com sucesso!");

            case 4:
                System.out.println("O Empregado pertence ao Sindicato?");
                System.out.println("(1) Sim");
                System.out.println("(2) Não");

                int isSindicate = Exceptions.readInt();
                setIsSindicate(isSindicate);

                if(isSindicate == 1) {
                    System.out.println("Digite o valor da taxa Sindical:\nR$: ");

                    double sindicalTax = Exceptions.readDouble();

                    sindicate.setSindicateId(getEmployeeId());
                    sindicate.setSindicateTax(sindicalTax);
                    setEmployeeId(getEmployeeId() + 1);
                }

                System.out.println("Sindicato do Empregado alterado com sucesso!");

                break;

        }
    }

    public abstract void salary();
    public abstract void payEmployee(ArrayList<Employee> employee, int index);

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsSindicate() {
        return isSindicate;
    }

    public void setIsSindicate(int isSindicate) {
        this.isSindicate = isSindicate;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public int getDayFrequency() {
        return dayFrequency;
    }

    public void setDayFrequency(int dayFrequency) {
        this.dayFrequency = dayFrequency;
    }

    public Sindicate getSindicate() {
        return sindicate;
    }

    public void setSindicate(Sindicate sindicate) {
        this.sindicate = sindicate;
    }

    @Override
    public String toString() {
        String string;

        string = "Número Empregado: " + this.employeeId + "		Nome: " + this.name;
        string += "\n--------------------------------------------------------------------------------------------------------\n";
        string += "Endereço: " + this.address;
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (this.paymentMethod == 1) {
            string += "Método de Pagamento: Cheque pelos correios";
        } else if (this.paymentMethod == 2) {
            string += "Método de Pagamento: Cheque em mãos";
        } else if (this.paymentMethod == 3) {
            string += "Método de Pagamento: Depósito em conta bancária";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (isSindicate == 1) {
            string += "Sindicado: Pertence		Número do Sindicato: " + this.sindicate.getSindicateId() + "		Taxa Sindical: R$ " + this.sindicate.getSindicateTax();
        } else {
            string += "Sindicado: Não Pertence";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        return string;
    }
}
