package System;

import java.util.ArrayList;
import Employee.Employee;

public class DatabaseSingleton {

    private static DatabaseSingleton uniqueInstance;
    private DatabaseSingleton() {}

    private ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

    public static synchronized DatabaseSingleton getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new DatabaseSingleton();
        }
        return uniqueInstance;
    }

    public int searchEmployee() {
        int i;

        System.out.println("Digite o número do Empregado:");
        int numberEmployee = Exceptions.readInt();

        if (employeeArrayList.isEmpty()) {
            System.out.println("\nErro: Não há empregados cadastrados.\n");
            return -1;
        }

        for (i=0; i < employeeArrayList.size(); i++) {
            if (employeeArrayList.get(i).getNumberEmployee() == numberEmployee) {
                break;
            }
        }

        return i;
    }

    public void removeEmployee() {
        System.out.println("\n\t**  	REMOVER FUNCIONÁRIO  	**\n");

        int index = searchEmployee();
        if (index == -1) return;

        System.out.println("\nRemovendo empregado...");

        try {
            employeeArrayList.remove(index);
            System.out.println("\nEmpregado removido com sucesso!\n");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nErro: Empregado não existe.\n");
        }
    }

    // GETTERS AND SETTERS

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(Employee employee) {
        this.employeeArrayList.add(employee);
    }

}
