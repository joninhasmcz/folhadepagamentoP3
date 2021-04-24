package PayrollClasses;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

    private static Scanner input;

    public static int readInt() {
        input = new Scanner(System.in);

        while(true) {
            try{
                int value = input.nextInt();
                return value;
            } catch(InputMismatchException e) {
                System.out.println("Aconteceu um Erro. Entrada Inválida. Por favor, digite um valor Inteiro");
            } finally {
                input.nextLine();
            }
        }
    }

    public static double readDouble() {
        input = new Scanner(System.in);

        while (true) {
            try {
                double value = input.nextDouble();
                return value;

            } catch (InputMismatchException e) {
                System.out.println("Aconteceu um Erro. Entrada Inválida. Por favor, digite um valor Double");
            } finally {
                input.nextLine();
            }
        }

    }
}
