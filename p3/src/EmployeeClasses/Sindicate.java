package EmployeeClasses;

import java.util.Scanner;
import PayrollClasses.Exceptions;

public class Sindicate {

    Scanner input = new Scanner(System.in);

    private int sindicateId;
    private double sindicateTax = 0;
    private double serviceTaxValue = 0;

    public int getSindicateId() {
        return sindicateId;
    }

    public void setSindicateId(int sindicateId) {
        this.sindicateId = sindicateId;
    }

    public double getSindicateTax() {
        return sindicateTax;
    }

    public void setSindicateTax(double sindicateTax) {
        this.sindicateTax = sindicateTax;
    }

    public double getServiceTaxValue() {
        return serviceTaxValue;
    }

    public void serviceTax() {
        System.out.println("\nDigite o serviço adicional pelo Sindicato:\nR$ ");
        String service = input.nextLine();

        System.out.println("Digite o valor da Taxa de Serviço");
        double serviceValue = Exceptions.readDouble();

        this.serviceTaxValue = serviceTaxValue + serviceValue;

        System.out.println("Número de Série do Sindicato: " + sindicateId);
        System.out.println("----------------------------");
        System.out.println("Serviço: " + service + "   Valor do Serviço: R$ " + serviceValue);
        System.out.println("----------------------------");
        System.out.println("Taxa de Serviço Registrado com Sucesso!!!");

    }


}
