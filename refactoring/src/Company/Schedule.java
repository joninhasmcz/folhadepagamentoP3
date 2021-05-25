package Company;

import java.util.ArrayList;

import Employee.Employee;
import System.DatabaseSingleton;
import System.Exceptions;

public class Schedule {

    private DatabaseSingleton database = DatabaseSingleton.getInstance();
    private ArrayList<Employee> employeeArrayList = database.getEmployeeArrayList();

    public void consultSchedule() {
        if (employeeArrayList.isEmpty()) {
            System.out.println("\nErro: Não há empregados cadastrados.\n");
            return;
        }

        for (int i=0; i < employeeArrayList.size(); i++) {
            System.out.println(employeeArrayList.get(i).toString() + "\n\n");
        }
    }

    public void newScedule() {

        int index = database.searchEmployee();

        String schedule = null;

        System.out.println("\nEscolha uma opção:\n(1) - Mensal\n(2) - Semanal");
        int option = Exceptions.readInt();

        if (option == 1) {
            System.out.println("\nEscolha o dia ou digite -1 para o último dia do mês");
            int option2 = Exceptions.readInt();

            employeeArrayList.get(index).setScheduleType("Mensal");

            if (option2 == -1) {
                employeeArrayList.get(index).setDayFrequency(30);
            } else {

                employeeArrayList.get(index).setDayFrequency(option2);
            }

        } else if (option == 2) {
            System.out.println("\nEscolha a frequencia:\n1 - Toda semana\n2 - A cada duas semanas\n3 - A cada três semanas\n");
            int option2 = Exceptions.readInt();

            if (option2 == 1) schedule = "1 - Semanal";
            else if (option2 == 2) schedule = "2 - Semanal";
            else if (option2 == 3) schedule = "3 - Semanal";

            employeeArrayList.get(index).setScheduleType(schedule);

            System.out.println("\nEscolha o dia da semana:\n1 - Segunda\n2 - Terça\n3 - Quarta\n4 - Quinta\n5 - Sexta");
            int option3 = Exceptions.readInt();

            employeeArrayList.get(index).setDayFrequency(option3);

        }

        System.out.println("\nNova agenda de pagamento criada com sucesso!\n");

    }


}
