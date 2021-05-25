package System;

public class Menu {

    private CalendarSingleton calendar = CalendarSingleton.getInstance();

    public void menuMain() {

        PayrollFacade payroll = new PayrollFacade();

        int day = calendar.getDay();
        int dayWeek = calendar.getDayWeek();
        int week = calendar.getWeek();
        int month = calendar.getMonth();
        int year = calendar.getYear();
        int last = calendar.lastDay(month);


        int option = printMenu();

        switch(option) {
            case 1:
                payroll.add();
                break;

            case 2:
                payroll.remove();
                break;

            case 3:
                payroll.timeCard();
                break;

            case 4:
                payroll.sell();
                break;

            case 5:
                payroll.serviceTax();
                break;

            case 6:
                payroll.edit();
                break;

            case 7:
                payroll.play(day, dayWeek, week, last);
                calendar.advanceDay();

                System.out.println("\nData: " + day + "/ " + month + " / " + year + " -  Folha de pagamento executada com sucesso!\n");
                break;

            case 8:

                break;

            case 9:
                payroll.paymentSchedule();
                break;

            case 10:
                payroll.newSchedule();
                break;

            case 0:
                System.exit(0);

            default:
                System.out.println("\nErro: Opção Inválida.\n");
        }
    }

    public int printMenu() {
        System.out.println("=============================== FOLHA DE PAGAMENTO =====================================");

        System.out.println(calendar.toString());

        System.out.println("\nEscolha uma opção:");
        System.out.println("(1) - Adicionar Empregado");
        System.out.println("(2) - Remover Empregado");
        System.out.println("(3) - Lançar um Cartão de Ponto");
        System.out.println("(4) - Lançar um Resultado Venda");
        System.out.println("(5) - Lançar uma Taxa de Serviço");
        System.out.println("(6) - Alterar Detalhes de um Empregado");
        System.out.println("(7) - Rodar a Folha de Pagamento para Hoje (após rodar, avança 1 dia)");
        System.out.println("(8) - Undo/redo");
        System.out.println("(9) - Agenda de Pagamento");
        System.out.println("(10) - Criação de Novas Agendas de Pagamento");
        System.out.println("(0) - Sair");
        System.out.println("=======================================================================================");

        return Exceptions.readInt();
    }

}
