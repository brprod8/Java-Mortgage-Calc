package br;

import java.text.NumberFormat;
import java.util.Scanner;


// MortgageCalculator with error Handling with (Java)
// BY:Robert Smith


public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR =12;
        final byte PERCENT = 100;



        // declaring variables
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;


        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Principal ($1k - $1M):");
           principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between $1k and $1M");
        }


        while(true) {
            System.out.print("Annual Interest Rare:");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <=30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while(true) {
            System.out.print("Period (Years):");
            byte years = scanner.nextByte();

            if (years >= 1 && years <=30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;

            }
            System.out.println("Enter a value between 1 and 30");
        }



        // Calculate the monthly payment
        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);

        double monthlyPayment = principal * (monthlyInterest * mathPower / (mathPower - 1));

        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Mortgage:" + monthlyPaymentFormatted);





    }
}