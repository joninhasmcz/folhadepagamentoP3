package com.company;

public class Employee {

    private int payment;
    private double salary;
    private int employeeType;

    public Employee (int payment, double salary, int employeeType) {
        this.salary = salary;

        if(payment == 1) {

        } else if(payment == 2) {

        } else if(payment == 3) {

        } else {
            System.out.println("Erro... Método não Aceito.");
        }
        if(employeeType == 1) {

        } else if(employeeType == 2) {

        } else if(employeeType == 3) {

        } else {
            System.out.println("Erro... Tipo de Empregado não Aceito.");
        }
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }
}
