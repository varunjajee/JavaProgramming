package com.muks.designpatterns.creational.AbstractFactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */
public class BankFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("HDFC")){
            return new HDFCBank();
        } else if(bank.equalsIgnoreCase("ICICI")){
            return new ICICIBank();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}
