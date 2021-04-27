package PayrollClasses;

import java.util.Calendar;

public class Main {

    static PaymentCalendar calendar = new PaymentCalendar();

    public static void main(String[] args) {

        Functionalities functionalities= new Functionalities();

        while (true) {

            int day = calendar.getDay();
            int dayWeek = calendar.getDayWeek();
            int week = calendar.getWeek();
            int month = calendar.getMonth();
            int year = calendar.getYear();
            int lastDay = calendar.lastDay(month);

            menu();

            int option = Exceptions.readInt();

            switch(option) {
                case 1:
                    functionalities.addEmployee();
                    break;

                case 2:
                    functionalities.removeEmployee();
                    break;

                case 3:
                    functionalities.launchTimeCard();
                    break;

                case 4:
                    functionalities.launchSellResult();
                    break;

                case 5:
                    functionalities.launchServiceTax();
                    break;

                case 6:
                    functionalities.alterDetails();
                    break;

                case 7:
                    functionalities.playPayroll(day, dayWeek, week, lastDay);
                    calendar.advanceDay();

                    System.out.println("\nData: " + day + "/ " + month + " / " + year + " -  Folha de pagamento executada com sucesso!\n");
                    break;

                case 8:
                    System.out.println("Não temos essa funcionalidade no momento...");
                    break;

                case 9:
                    functionalities.schedulePayment();
                    break;

                case 10:
                    functionalities.newSchedule();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("\nErro: Opção Inválida.\n");
            }

        }
    }

    public static void menu() {
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
    }
}
