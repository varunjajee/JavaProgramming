package com.muks.DesignPatterns.creational.AbstractFactoryPattern;

/**
 * Created by mukthar.ahmed on 12/27/15.
 */
public class PersonalLoan extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}
