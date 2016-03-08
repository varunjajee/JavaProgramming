package com.muks.DesignPatterns.creational.AbstractFactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */

public class FactoryCreator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("bank")) {
            return new BankFactory();
        }
        else if (choice.equalsIgnoreCase("loan")) {
            return new LoanFactory();
        }
        return null;
    }
}
