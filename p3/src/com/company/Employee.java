package com.company;

public class Employee {

    private int paymentType;
    private double salary;
    private int employeeType;

    public Employee (int paymentType, double salary, int employeeType) {
        this.salary = salary;

        if(paymentType == 1) {

        } else if(paymentType == 2) {

        } else if(paymentType == 3) {

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
        return paymentType;
    }

    public void setPayment(int payment) {
        this.paymentType = payment;
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
