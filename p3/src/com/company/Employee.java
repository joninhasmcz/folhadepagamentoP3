package com.company;

public class Employee {

    private String name;
    private String cpf;
    private int employeeId;


    public Employee (String name, String cpf, int employeeId) {

        if(validadeData(name, cpf) == true) {
            this.name = name;
            this.cpf = cpf;
            this.employeeId = employeeId;
            System.out.println("Sucesso em Salvar os Dados");

        } else {
            System.out.println("Erro na Verificação dos Dados do Empregado");
        }

    }
    public boolean validadeData (String name, String cpf) {
        int contadorCpf = 0;

        for(int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i)) == true) {
                System.out.println("Erro na Validação do Nome !!! Possui Números");
                return false;
            }
        }
        for(int i = 0; i < cpf.length(); i++) {
            if (Character.isLetter(cpf.charAt(i)) == true || cpf.charAt(i) == ' ') {
                System.out.println("Erro na Validação do CPF !!! Possui Letras ou Espaços Vazios");
                return false;
            }
            contadorCpf++;
        }
        if(contadorCpf != 11) {
            return false;
        }
        return true;
    }
    public String printEmployee(Employee empregado) {
        return "Name: " + this.name + "\ncpf: " + this.cpf;
    }

}
