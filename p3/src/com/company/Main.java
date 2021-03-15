package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n1,n2;
        int op;
        double salaryEmployee;
        System.out.println("Bem Vindo ao Sistema Folha de Pagamento");
        System.out.println("Escolha dentre as opções");

        if(op == 1) {
            System.out.println("Defina o Salário");
            salaryEmployee = input.nextDouble();

            System.out.println("Defina o método de pagamento do empregado: ");
            System.out.println("1. Cheque pelos Correios");
            System.out.println("2. Cheque em Mãos");
            System.out.println("3. Depósito");
            n1 = input.nextInt();

            System.out.println("Defina o tipo de empregado:");
            System.out.println("1. Horistas");
            System.out.println("2. Assaliariados");
            System.out.println("3. Semanais");
            n2 = input.nextInt();

            Employee empregado1 = new Employee(n1, salaryEmployee, n2);
        }




    }
}
