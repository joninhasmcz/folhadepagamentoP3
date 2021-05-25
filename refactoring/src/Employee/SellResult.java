package Employee;

import System.DatabaseSingleton;
import System.Exceptions;

public class SellResult {

    private DatabaseSingleton database = DatabaseSingleton.getInstance();
    private Comissioned comissioned;

    public boolean verifyComissioned() {

        int index = database.searchEmployee();
        if (index == -1) return false;

        if (database.getEmployeeArrayList().get(index) instanceof Comissioned) {
            comissioned = (Comissioned) database.getEmployeeArrayList().get(index);

            return true;
        }

        else return false;
    }

    public void playSellResult() {

        if (verifyComissioned() == true) {

            System.out.println("\nDia da venda:");
            int daySell = Exceptions.readInt();

            System.out.println("\nMês da venda:");
            int monthSell = Exceptions.readInt();

            System.out.println("\nAno da venda:");
            int yearSell = Exceptions.readInt();

            System.out.print("\nValor da venda:\nExemplo: 1500 - 3000.56\nR$ ");
            double valueSell = Exceptions.readDouble();

            comissioned.setComissionValue((valueSell * comissioned.getComission())/100);

            System.out.println("\n===============================Registro de Venda=================================");
            System.out.println("Nome: " + comissioned.getName() + "		Número do empregado: " + comissioned.getNumberEmployee());
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Data da venda: " + daySell + "/ " + monthSell + "/" + yearSell + "		Valor da comissão: R$ " + ((valueSell * comissioned.getComission())/100));
            System.out.println("==================================================================================");

            System.out.println("\nResultado da venda registrado com sucesso!\n");

        } else {System.out.println("\nErro: Empregado não é comissionado.\n");}
    }
}
