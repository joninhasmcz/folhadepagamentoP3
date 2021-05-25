package System;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

    public static Scanner input;

    public static int readInt() {
        input = new Scanner(System.in);

        while(true) {
            try {
                int value = input.nextInt();
                return value;

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
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
                System.out.println("Erro: Entrada inválida. Digite um número real.");
            } finally {
                input.nextLine();
            }
        }

    }
}
