package com.muks.oopsandjava.concepts.threads.d_prodconsumerproblem.d_BankingEx.RaceBySynchro;

import com.muks.oopsandjava.concepts.threads.d_prodconsumerproblem.d_BankingEx.Banking.BankAccount;

import java.util.Random;

/*
 * Created by mukthar.ahmed on 11/1/15.
 */
public class SynchronizationEgMikeAndMolyJob implements Runnable{
    private BankAccount account = new BankAccount(200);
    private ThreadLocal<Integer> TOTAL_WITHDRAWN = new ThreadLocal<>();


    @Override
    public void run() {
        TOTAL_WITHDRAWN.set(0);
        for (int i = 1; i <= 60; i++) {
            makeWithdrawal(10);
            if (account.getAccountBalance() < 0) {
                System.out.println("+ ChatUser Warning: Insufficient balance notice is sent...");
                System.exit(0);
            }
        }
        /*
        System.out.println("Withdraw amount = " + account.withdrawal(90) + " and " +
                "Account Balance = " + account.getAccountBalance());

        System.out.println("Withdraw amount = " + account.withdrawal(30) + " and " +
                "Account Balance = " + account.getAccountBalance());
                */
    }

    /*
        synchronized keyword is used to obtain lock over a method so that only one thread
         has is in running state while others wait till it completes.
     */

    // private synchronized boolean makeWithdrawal(int withdrawalAmount) {
    private synchronized void makeWithdrawal(int withdrawalAmount) {

        if (account.getAccountBalance() >= withdrawalAmount) {
            System.out.println("\n+ Account balance is sufficient enough to make a withdrawl...");
            System.out.println(
                    Thread.currentThread().getName() + " is about to make an withdrawal.");

            Random random = new Random();
            int sleepTime = random.nextInt(500) + 510;
            System.out.println("+ Sleeping for - " + sleepTime);

            //Thread.sleep(sleepTime);

            System.out.println("+ Wake-up Call - "
                    + Thread.currentThread().getName() + " just WOKE UP...");


            TOTAL_WITHDRAWN.set(TOTAL_WITHDRAWN.get() + account.withdrawal(10));
            System.out.println("+ Total Withdrawal by " + Thread.currentThread().getName()
                    + " = " + TOTAL_WITHDRAWN.get());
            System.out.println("+ Account Balance = " + account.getAccountBalance() + "\n");

        } else {
            System.out.println("+ WARNING: Sorry " + Thread.currentThread().getName()
                    + ", insufficient account balance!!!");
        }
    }


    public static void main(String[] args) {
        SynchronizationEgMikeAndMolyJob synchroMikeAndMolyJob = new SynchronizationEgMikeAndMolyJob();
        Thread one = new Thread(synchroMikeAndMolyJob);
        Thread two = new Thread(synchroMikeAndMolyJob);

        one.setName("Mike");
        two.setName("Molly");

        one.start();
        two.start();
    }


}
