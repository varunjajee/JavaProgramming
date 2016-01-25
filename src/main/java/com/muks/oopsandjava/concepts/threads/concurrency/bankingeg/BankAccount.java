package com.muks.oopsandjava.concepts.threads.concurrency.bankingeg;

/*
 * Created by mukthar.ahmed on 11/1/15.
 *
 *  A race condition is a situation in which two or more threads or processes are reading or
 *  writing some shared name, and the final result depends on the timing of how the threads are
 *  scheduled. Race conditions can lead to unpredictable results and subtle program bugs
 *
 */
public class BankAccount {
    private int accountBalance = 1;   // should be static else it will go as transient variable

    public BankAccount(int depositAmount) {
        this.accountBalance = depositAmount;
    }

    public int withdrawal(int withdrawalAmount) {
        accountBalance = accountBalance - withdrawalAmount;
        return withdrawalAmount;
    }

    public int getAccountBalance(){
        return accountBalance;
    }
}
