package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int contEmployee = 0;
        int op;
        double salaryEmployee;

        System.out.println("Bem Vindo ao Sistema Folha de Pagamento");
        /* System.out.println("Escolha dentre as opções");
        op = input.nextInt();

        if(op == 1) { */


        Employee empregado1 = new Employee("Jonas", "11315461480", contEmployee, "Travessa Maria Erivânia NM 5/" );
        System.out.println(empregado1.printEmployee(empregado1));





    }
}
