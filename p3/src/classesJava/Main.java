package classesJava;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int contEmployee = 0;
        int op;
        double salaryEmployee;

        System.out.println("Bem Vindo ao Sistema Folha de Pagamento");
        System.out.println("Escolha dentre as opções");
        System.out.println("(0) - Para Sair");
        System.out.println("(1) - Adicionar um Empregado");
        System.out.println("(2) - Remover um Empregado");
        System.out.println("(3) - Lançar Cartão de Ponto de um Empregado");
        System.out.println("(4) -  Lançar um Resultado de Venda de um Empregado");
        System.out.println("(5) - Lançar uma Taxa de Serviço");
        System.out.println("(6) - Alterar Informações de um Empregado");
        System.out.println("(7) - Rodar a Folha de Pagamento para Hoje");
        System.out.println("(8) -  Undo/Rendo");
        System.out.println("(9) - Agenda de Pagamento");
        System.out.println("(10) - Criar Novas Agendas de Pagamento");
        op = input.nextInt();

        if(op == 1) {


        Employee hourly1 = new Hourly(54);
        hourly1.setName("Jonas");
        hourly1.getName();





    }
}
