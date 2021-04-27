package PayrollClasses;

import java.util.ArrayList;
import EmployeeClasses.Salaried;
import EmployeeClasses.Comissioned;
import EmployeeClasses.Employee;
import EmployeeClasses.Hourly;

public class EditDetails {
    public static void alterType(ArrayList<Employee> listEmployee, int item) {
        Employee newEmployee = null;

        System.out.println("Escolha o tipo do empregado:");
        System.out.println("(1) - Horista");
        System.out.println("(2) - Assalariado");
        System.out.println("(3) - Comissionado");
        int type = Exceptions.readInt();

        if(type == 1) {
            newEmployee = new Hourly(listEmployee.get(item).getEmployeeId(), listEmployee.get(item).getName(),
                    listEmployee.get(item).getAddress(), listEmployee.get(item).getPaymentMethod(), listEmployee.get(item).getIsSindicate(),
                    type, listEmployee.get(item).getScheduleType(), listEmployee.get(item).getDayFrequency());

            newEmployee.salary();

            if(listEmployee.get(item).getIsSindicate() == 1) {
                newEmployee.getSindicate().setSindicateId(listEmployee.get(item).getSindicate().getSindicateId());
                newEmployee.getSindicate().setSindicateTax(listEmployee.get(item).getSindicate().getSindicateTax());
            }

        } else if (type == 2) {
            newEmployee = new Salaried(listEmployee.get(item).getEmployeeId(), listEmployee.get(item).getName(),
                    listEmployee.get(item).getAddress(), listEmployee.get(item).getPaymentMethod(), listEmployee.get(item).getIsSindicate(),
                    type, listEmployee.get(item).getScheduleType(), listEmployee.get(item).getDayFrequency());

            newEmployee.salary();

            if (listEmployee.get(item).getIsSindicate() == 1) {
                newEmployee.getSindicate().setSindicateId(listEmployee.get(item).getSindicate().getSindicateId());
                newEmployee.getSindicate().setSindicateTax(listEmployee.get(item).getSindicate().getSindicateTax());
            }


        } else if (type == 3) {
            newEmployee = new Comissioned(listEmployee.get(item).getEmployeeId(), listEmployee.get(item).getName(),
                    listEmployee.get(item).getAddress(), listEmployee.get(item).getPaymentMethod(), listEmployee.get(item).getIsSindicate(),
                    type, listEmployee.get(item).getScheduleType(), listEmployee.get(item).getDayFrequency());

            newEmployee.salary();

            if (listEmployee.get(item).getIsSindicate() == 1) {
                newEmployee.getSindicate().setSindicateId(listEmployee.get(item).getSindicate().getSindicateId());
                newEmployee.getSindicate().setSindicateTax(listEmployee.get(item).getSindicate().getSindicateTax());
            }
        }

        listEmployee.add(newEmployee);
        listEmployee.remove(item);

        System.out.println("\nTipo do empregado alterado com sucesso!");

    }
}
