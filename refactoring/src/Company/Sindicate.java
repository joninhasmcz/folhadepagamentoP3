package Company;

import java.util.Scanner;

import System.DatabaseSingleton;
import System.Exceptions;

public class Sindicate {

    private DatabaseSingleton database = DatabaseSingleton.getInstance();
    private int numberSindicate;
    private double sindicalTax = 0;
    private double valueServiceTax = 0;

    Scanner input = new Scanner(System.in);

    public boolean verifySindicate() {
        int index = database.searchEmployee();
        if (index == -1) return false;

        if (database.getEmployeeArrayList().get(index).getIsSindicate() == 1) {
            return true;
        } else return false;
     }

    public void serviceTax() {

        System.out.print("\nDigite o serviço adicional prestado pelo sindicato:\n");
        String renderService = input.nextLine();

        System.out.println("\nValor da taxa de serviço: R$ ");
        double value = Exceptions.readDouble();

        this.valueServiceTax = valueServiceTax + value;

        System.out.println("\n============================Registro de Serviço=================================");
        System.out.println("Número do sindicato: " + numberSindicate);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Serviço: " + renderService + "		Valor do serviço: R$ " + value);
        System.out.println("==================================================================================");

        System.out.println("\nTaxa de serviço registrada com sucesso!\n");

    }

    // GETTERS AND SETTERS


    public int getNumberSindicate() {
        return numberSindicate;
    }

    public void setNumberSindicate(int numberSindicate) {
        this.numberSindicate = numberSindicate;
    }

    public double getSindicalTax() {
        return sindicalTax;
    }

    public void setSindicalTax(double sindicalTax) {
        this.sindicalTax = sindicalTax;
    }

    public double getValueServiceTax() {
        return valueServiceTax;
    }

    public void setValueServiceTax(double valueServiceTax) {
        this.valueServiceTax = valueServiceTax;
    }
}



