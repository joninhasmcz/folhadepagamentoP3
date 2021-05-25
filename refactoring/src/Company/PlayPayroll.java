package Company;

import java.util.ArrayList;

import Employee.Employee;
import System.DatabaseSingleton;

public class PlayPayroll {

    private DatabaseSingleton database = DatabaseSingleton.getInstance();
    private ArrayList<Employee> employeeArrayList = database.getEmployeeArrayList();

    public void playPayroll(int day, int dayWeek, int week, int last) {
        System.out.println("\n**  	RODAR A FOLHA DE PAGAMENTO  	**\n");
        System.out.println("Verificando Empregados...\n");

        for (int i = 0; i < employeeArrayList.size(); i++) {

            if ((employeeArrayList.get(i).getScheduleType() == "1 - Semanal") && (employeeArrayList.get(i).getDayFrequency() == dayWeek)) {

                employeeArrayList.get(i).payEmployee(employeeArrayList, i);

            } else if ((employeeArrayList.get(i).getScheduleType() == "2 - Semanal") && (employeeArrayList.get(i).getDayFrequency() == dayWeek)
                    && (week == 2 || week == 4)) {

                employeeArrayList.get(i).payEmployee(employeeArrayList, i);

            } else if ((employeeArrayList.get(i).getScheduleType() == "3 - Semanal") && (employeeArrayList.get(i).getDayFrequency() == dayWeek)
                    && (week == 3)) {

                employeeArrayList.get(i).payEmployee(employeeArrayList, i);

            } else if (employeeArrayList.get(i).getScheduleType() == "Mensal") {

                if (employeeArrayList.get(i).getDayFrequency() == 28 || employeeArrayList.get(i).getDayFrequency() == 30
                        || employeeArrayList.get(i).getDayFrequency() == 31) { // Verifica se o dia na agenda não foi alterado

                    employeeArrayList.get(i).setDayFrequency(last);
                }

                if (employeeArrayList.get(i).getDayFrequency() == day) {
                    employeeArrayList.get(i).payEmployee(employeeArrayList, i);

                }
            }
        }

    }
}
