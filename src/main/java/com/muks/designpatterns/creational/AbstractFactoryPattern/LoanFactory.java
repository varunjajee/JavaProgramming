package com.muks.designpatterns.creational.AbstractFactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */
public class LoanFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if (loan == null)
            return null;

        if (loan.equalsIgnoreCase("personal")) {
            return new PersonalLoan();
        }
        else  if (loan.equalsIgnoreCase("home")) {
            return new HomeLoan();
        }

        return null;
    }
}
