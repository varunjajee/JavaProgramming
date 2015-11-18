package com.muks.headfirstjava.threads.concurrency;

/*
 * Created by mukthar.ahmed on 11/1/15.
 */
public class BankAccount {
    private int accountBalance = 1;   // should be static else it will go as transient variable

    public int withdrawal(int withdrawalAmount) {
        accountBalance = accountBalance - withdrawalAmount;
        return withdrawalAmount;
    }

    public BankAccount(int depositAmount) {
        this.accountBalance = depositAmount;
    }

    public int getAccountBalance(){
        return accountBalance;
    }
}
