package Employee;

import java.util.ArrayList;
import java.util.Scanner;

import Company.Sindicate;
import System.Exceptions;

public abstract class Employee {

    private int numberEmployee;
    private String name;
    private String address;
    private int type;
    private int paymentMethod;
    private int isSindicate = 0;
    private String scheduleType;
    private int dayFrequency;

    Sindicate sindicate = new Sindicate();

    public Employee(int numberEmployee, String name, String address, int type, int paymentMethod, int isSindicate, String scheduleType, int dayWeek) {
        this.numberEmployee = numberEmployee;
        this.name = name;
        this.address = address;
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.isSindicate = isSindicate;
        this.scheduleType = scheduleType;
        this.dayFrequency = dayWeek;
    }

    Scanner input = new Scanner(System.in);

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    public abstract void entranceSalary();
    public abstract void payEmployee(ArrayList<Employee> employee, int index);

    public void alterDetails() {

        System.out.println("\n**  	ALTERAR DETALHES DO EMPREGADO  	**\n");
        System.out.println("Escolha uma opção:");
        System.out.println("(1) - Alterar Nome");
        System.out.println("(2) - Alterar Endereço");
        System.out.println("(3) - Alterar Método de Pagamento");
        System.out.println("(4) - Alterar Sindicato");
        System.out.println("(5) - Alterar Tipo");

        int option = Exceptions.readInt();

        switch(option) {
            case 1:
                System.out.println("Digite o nome do empregado:");
                String name = input.nextLine();

                setName(name);

                System.out.println("\nNome do empregado alterado com sucesso!\n");

                break;

            case 2:
                System.out.println("\nDigite o endereço do empregado:");
                String address = input.nextLine();

                setAddress(address);

                System.out.println("\nEndereço do empregado alterado com sucesso!\n");

                break;

            case 3:
                System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
                int paymentMethod = Exceptions.readInt();

                setPaymentMethod(paymentMethod);

                System.out.println("\nMétodo de pagamento do empregado alterado com sucesso!\n");

                break;

            case 4:
                System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
                int isSindicate = Exceptions.readInt();

                setIsSindicate(isSindicate);

                if (isSindicate == 1) {
                    System.out.print("Digite o valor da taxa sindical:\nR$ ");
                    double sindicalTax = Exceptions.readDouble();

                    sindicate.setNumberSindicate(getNumberEmployee());
                    sindicate.setSindicalTax(sindicalTax);

                    setNumberEmployee(getNumberEmployee() + 1);
                }

                System.out.println("\nSindicato do empregado alterado com sucesso!\n");

                break;
        }
    }

    // GETTERS AND SETTERS

    public int getNumberEmployee() {
        return this.numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getIsSindicate() {
        return this.isSindicate;
    }

    public void setIsSindicate(int isSindicate) {
        this.isSindicate = isSindicate;
    }

    public Sindicate getSindicate() {
        return sindicate;
    }

    public void setSindicate(Sindicate sindicate) {
        this.sindicate = sindicate;
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

    @Override
    public String toString() {
        String string;

        string = "Número Empregado: " + this.numberEmployee + "		Nome: " + this.name;
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
            string += "Sindicado: Pertence		Número do Sindicato: " + this.sindicate.getNumberSindicate() + "		Taxa Sindical: R$ " + this.sindicate.getSindicalTax();
        } else {
            string += "Sindicado: Não Pertence";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        return string;
    }

}
