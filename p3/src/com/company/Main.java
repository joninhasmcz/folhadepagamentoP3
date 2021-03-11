package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n1, n2, sum;

        System.out.println("Enter the first Integer: ");
        n1 = input.nextInt();

        System.out.println("Enter the second Integer: ");
        n2 = input.nextInt();

        sum = n1 + n2;
        System.out.printf("Soma: %d",sum);

    }
}
