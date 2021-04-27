package PayrollClasses;

import java.util.ArrayList;
import EmployeeClasses.Employee;



public class Schedule {

    public int searchEmployee(ArrayList<Employee> listEmployees, int numberEmployee) {
        int item;

        if(listEmployees.isEmpty()) {
            System.out.println("\nDesculpe, encontramos um Erro. Não há Empregados cadastrados.");
            return -1;
        } else {
            for(item = 0; item < listEmployees.size(); item++) {
                if(listEmployees.get(item).getEmployeeId() == numberEmployee) {
                    break;
                }
            }
        }

        return item;
    }

    public void querySchedule(ArrayList<Employee> listEmployees) {
        if(listEmployees.isEmpty()) {
            System.out.println("\nDesculpe, encontramos um Erro. Não há Empregados cadastrados.");
            return;
        } else {
            for(int item = 0; item < listEmployees.size(); item++) {
                System.out.println(listEmployees.get(item).toString() + "\n\n");
            }
        }
    }

    public void newSchedule(ArrayList<Employee> listEmployees, int index) {
        String schedule = null;

        System.out.println("\nPor favor, escolha uma opção:");
        System.out.println("(1) Mensal");
        System.out.println("(2) Semanal");
        int option = Exceptions.readInt();

        if(option == 1) {
            System.out.println("\nEscolha o dia ou digite -1 para o último dia do mês");
            int option2 = Exceptions.readInt();

            listEmployees.get(index).setScheduleType("Mensal");

            if (option2 == -1) {
                listEmployees.get(index).setDayFrequency(30);
            } else {

                listEmployees.get(index).setDayFrequency(option2);
            }
        }  else if (option == 2) {
            System.out.println("\nEscolha a frequencia:\n(1)  Toda semana\n(2) A cada duas semanas\n(3) A cada três semanas\n");
            int option2 = Exceptions.readInt();

            if (option2 == 1) schedule = "1 - Semanal";
            else if (option2 == 2) schedule = "2 - Semanal";
            else if (option2 == 3) schedule = "3 - Semanal";

            listEmployees.get(index).setScheduleType(schedule);

            System.out.println("\nEscolha o dia da semana:\n(1) Segunda\n(2) Terça\n(3) Quarta\n(4) Quinta\n(5) Sexta");
            int option3 = Exceptions.readInt();

            listEmployees.get(index).setDayFrequency(option3);

        }

        System.out.println("\nNova agenda de pagamento criada com sucesso!\n");
    }


}
