package Company;

import java.util.Scanner;

import Employee.Salaried;
import Employee.Comissioned;
import Employee.Hourly;
import System.DatabaseSingleton;
import System.Exceptions;

public class AddEmployee {

    private DatabaseSingleton database;
    private Hourly hourly;
    private Salaried salaried;
    private Comissioned comissioned;

    static private int numberSindicate = 1;
    static private int numberEmployee = 1;

    Scanner input = new Scanner(System.in);

    public void add() {

        database = DatabaseSingleton.getInstance();
        double sindicalTax = 0.0;

        System.out.println("\n**  ADICIONAR EMPREGADO  **\n");

        System.out.println("Digite o nome do empregado:");
        String name = input.nextLine();

        System.out.println("\nDigite o endereço do empregado:");
        String address = input.nextLine();

        System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
        int paymentMethod = Exceptions.readInt();

        System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
        int isSindicate = Exceptions.readInt();

        if (isSindicate == 1) {
            System.out.print("Digite o valor da taxa sindical:\nR$ ");
            sindicalTax = Exceptions.readDouble();
        }

        System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
        int type = Exceptions.readInt();


        if (type == 1) {

            hourly = new Hourly(numberEmployee, name, address, paymentMethod, isSindicate, type, "1 - Semanal", 5);

            hourly.entranceSalary();

            if (isSindicate == 1) {
                hourly.getSindicate().setNumberSindicate(numberSindicate);
                hourly.getSindicate().setSindicalTax(sindicalTax);
                numberSindicate++;
            }

            database.setEmployeeArrayList(hourly);

        } else if (type == 2) {
            salaried = new Salaried(numberEmployee, name, address, paymentMethod, isSindicate, type, "Mensal", 31);

            salaried.entranceSalary();

            if (isSindicate == 1) {
                salaried.getSindicate().setNumberSindicate(numberSindicate);
                salaried.getSindicate().setSindicalTax(sindicalTax);
                numberSindicate++;
            }

            database.setEmployeeArrayList(salaried);

        } else if (type == 3) {
            comissioned = new Comissioned(numberEmployee, name, address, paymentMethod, isSindicate, type, "2 - Semanal", 5);

            comissioned.entranceSalary();

            if (isSindicate == 1) {
                comissioned.getSindicate().setNumberSindicate(numberSindicate);
                comissioned.getSindicate().setSindicalTax(sindicalTax);
                numberSindicate++;
            }

            database.setEmployeeArrayList(comissioned);

        } else {
            System.out.println("\nErro: Opção Inválida.\n");
        }

        System.out.println("\nEmpregado cadastrado com sucesso!\n");
        numberEmployee++;
    }


}
