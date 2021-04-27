package PayrollClasses;

import java.util.ArrayList;
import java.util.Scanner;

import EmployeeClasses.Salaried;
import EmployeeClasses.Comissioned;
import EmployeeClasses.Employee;
import EmployeeClasses.Hourly;

public class Functionalities {
    static Scanner input = new Scanner(System.in);

    private static int employeeId = 1, sindicateId = 1;
    private static double sindicalTax = 0;

    static ArrayList<Employee> listEmployees = new ArrayList<Employee>();
    Schedule schedule = new Schedule();

    public void addEmployee() {
        System.out.println("** Adicionando um Empregado **\n");

        System.out.println("Digite o Nome do Empregado:");
        String name = input.nextLine();

        System.out.println("\nDigite o Endereço do Empregado");
        String address = input.nextLine();

        System.out.println("\nMétodo de Pagamento do Empregado:");
        System.out.println("(1) - Cheque pelos Correios");
        System.out.println("(2) - Cheque em Mãos");
        System.out.println("(3) - Depósito em Conta");
        int paymentMethod = Exceptions.readInt();

        System.out.println("\nO Empregado pertence a um Sindicato?");
        System.out.println("(1) - Sim");
        System.out.println("(0) - Não");
        int isSindicate = Exceptions.readInt();

        if(isSindicate == 1) {
            System.out.println("\nDigite o valor da Taxa Sindical:\nR$: ");
            sindicalTax = Exceptions.readDouble();
        }

        System.out.println("\nQual é o tipo de Empregado:");
        System.out.println("(1) - Horista");
        System.out.println("(2) - Salariado");
        System.out.println("(3) - Comissionado");
        int typeEmployee = Exceptions.readInt();

        if(typeEmployee == 1) {
            Hourly hourly = new Hourly(employeeId, name, address, paymentMethod, isSindicate, typeEmployee, "1 - Semanal", 5);

            hourly.salary();

            if(isSindicate == 1) {
                hourly.getSindicate().setSindicateId(sindicateId);
                hourly.getSindicate().setSindicateTax(sindicalTax);
                sindicateId++;
            }

            listEmployees.add(hourly);

        } else if(typeEmployee == 2) {
            Salaried salaried = new Salaried(employeeId, name, address, paymentMethod, isSindicate, typeEmployee, "Semanal", 31);

            salaried.salary();

            if(isSindicate == 1) {
                salaried.getSindicate().setSindicateId(sindicateId);
                salaried.getSindicate().setSindicateTax(sindicalTax);
                sindicateId++;
            }

            listEmployees.add(salaried);

        } else if(typeEmployee == 3) {
            Comissioned comissioned = new Comissioned(employeeId, name, address, paymentMethod, isSindicate, typeEmployee, "2 - Semanal", 5);

            comissioned.salary();

            if (isSindicate == 1) {
                comissioned.getSindicate().setSindicateId(sindicateId);
                comissioned.getSindicate().setSindicateTax(sindicalTax);
                sindicateId++;
            }

            listEmployees.add(comissioned);

        } else {
            System.out.println("\nErro: Opção Inválida.\\n");
        }

        System.out.println("\nEmpregado foi cadastrado com Sucesso!\n");

        employeeId++;

    }

    public void removeEmployee() {
        System.out.println("** Removendo um Empregado **\n");

        System.out.println("Digite o número do Empregado: ");
        int employeeIdTemp = Exceptions.readInt();

        int index = schedule.searchEmployee(listEmployees, employeeIdTemp);

        if(index == -1) {
            // Colocar Retorno
            return;
        }
        else {
            listEmployees.remove(index);
            System.out.println("\nEmpregado foi removido com Sucesso!\n");
        }

    }

    public void launchTimeCard() {
        System.out.println("** Lançando um Cartão de Ponto do Empregado **");
        System.out.println("Digite o número do Empregado: ");
        int employeeIdTemp = Exceptions.readInt();

        int index = schedule.searchEmployee(listEmployees, employeeIdTemp);

        try {
            if (index == -1) return;

            Hourly hourly = (Hourly) listEmployees.get(index);
            hourly.timeCard();

        } catch (Exception e) {
            System.out.println("\nErro: Empregado não é horista.\n");
        }
    }

    public void launchSellResult() {
        System.out.println("\n** Lançando um resultado de Venda de um Empregado **\n");
        System.out.println("Digite o número do Empregado:");
        int employeeIdTemp = Exceptions.readInt();

        int index = schedule.searchEmployee(listEmployees, employeeIdTemp);

        try {
            if (index == -1) return;

            Comissioned comissioned = (Comissioned) listEmployees.get(index);
            comissioned.sellResult();

        } catch (Exception e) {
            System.out.println("\nErro: Empregado não é comissionado.\n");
        }
    }

    public void launchServiceTax() {
        System.out.println("\n** Lançando uma taxa de Serviço de um Empregado **\n");
        System.out.println("Digite o número do Empregado:");
        int employeeIdTemp = Exceptions.readInt();

        int index = schedule.searchEmployee(listEmployees, employeeIdTemp);
        if (index == -1) return;

        if (listEmployees.get(index).getIsSindicate() == 1) {
            listEmployees.get(index).getSindicate().serviceTax();

        } else {
            System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
        }

    }

    public void alterDetails() {
        System.out.println("\n** Alterando os dados de um Usuário **\n");
        System.out.println("Digite o número do Empregado:");
        int employeeIdTemp = Exceptions.readInt();

        int index = schedule.searchEmployee(listEmployees, employeeIdTemp);
        if (index == -1) return;

        System.out.println("Escolha uma opção:");
        System.out.println("(1) - Alterar Nome");
        System.out.println("(2) - Alterar Endereço");
        System.out.println("(3) - Alterar Método de Pagamento");
        System.out.println("(4) - Alterar Sindicato");
        System.out.println("(5) - Alterar Tipo");

        int option = Exceptions.readInt();

        if (option <=4 & option > 0) {
            listEmployees.get(index).editDetails(option);

        } else if(option == 5) {
            EditDetails.alterType(listEmployees, index);

        } else {
            System.out.println("\nErro: Opção Inválida.\n");
        }

    }

    public void playPayroll(int day, int dayWeek, int week, int last) {
        System.out.println("\n** Rodando a Folha de Pagamento **\n");
        System.out.println("Verificando Empregados...\n");

        for (int i=0; i < listEmployees.size(); i++) {

            if ((listEmployees.get(i).getScheduleType() == "1 - Semanal") && (listEmployees.get(i).getDayFrequency() == dayWeek)) {

                listEmployees.get(i).payEmployee(listEmployees, i);

            } else if ((listEmployees.get(i).getScheduleType() == "2 - Semanal") && (listEmployees.get(i).getDayFrequency() == dayWeek)
                    && (week == 2 || week == 4)) {

                listEmployees.get(i).payEmployee(listEmployees, i);

            } else if ((listEmployees.get(i).getScheduleType() == "3 - Semanal") && (listEmployees.get(i).getDayFrequency() == dayWeek)
                    && (week == 3)) {

                listEmployees.get(i).payEmployee(listEmployees, i);

            } else if (listEmployees.get(i).getScheduleType() == "Mensal") {

                if (listEmployees.get(i).getDayFrequency() == 28 || listEmployees.get(i).getDayFrequency() == 30
                        || listEmployees.get(i).getDayFrequency() == 31) { // Verifica se o dia na agenda não foi alterado

                    listEmployees.get(i).setDayFrequency(last);
                }

                if (listEmployees.get(i).getDayFrequency() == day) {
                    listEmployees.get(i).payEmployee(listEmployees, i);

                }
            }
        }

    }


    public void schedulePayment() {
        System.out.println("\n** Agenda de Pagamento **\n");

        schedule.querySchedule(listEmployees);

    }

    public void newSchedule() {
        System.out.println("\n** Criando Agenda de Pagamento **\n");
        System.out.println("Digite o número do Empregado:");
        int nEmpTemp = Exceptions.readInt();

        int index = schedule.searchEmployee(listEmployees, nEmpTemp);
        if (index == -1) return;

        schedule.newSchedule(listEmployees, index);

    }

    public static int getSindicateId() {
        return sindicateId;
    }

    public static void setSindicateId(int sindicateId) {
        Functionalities.sindicateId = sindicateId;
    }
}
