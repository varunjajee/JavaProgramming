package com.muks.designpatterns.creational.AbstractFactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */
public class AbstractFactoryPatternExample {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name of Bank from where you want to take loan amount: ");

        try {
            String bankName = br.readLine();
            System.out.print("\nEnter the type of loan e.g. home OR person : ");

            String loanName = br.readLine();
            AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
            Bank b = bankFactory.getBank(bankName);
            System.out.print("\nEnter the interest rate for " + b.getBankName()+ ": ");

            double rate = Double.parseDouble(br.readLine());
            System.out.print("\nEnter the loan amount you want to take: ");

            double loanAmount = Double.parseDouble(br.readLine());

            System.out.print("\nEnter the number of years to pay your entire loan amount: ");
            int years = Integer.parseInt(br.readLine());

            System.out.print("\n");
            System.out.println("you are taking the loan from "+ b.getBankName());

            AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
            Loan loan = loanFactory.getLoan(loanName);
            loan.getInterestRate(rate);
            loan.calculateLoanPayment(loanAmount,years);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
