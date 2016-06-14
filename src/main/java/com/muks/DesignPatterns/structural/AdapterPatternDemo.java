package com.muks.DesignPatterns.structural;

/*
 * Created by mukthar.ahmed on 12/28/15.
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        CreditCard newCustomer = new BankCustomer();
        newCustomer.giveBankDetails();
        System.out.println(newCustomer.isElgibleForCreditCard());
    }
}
