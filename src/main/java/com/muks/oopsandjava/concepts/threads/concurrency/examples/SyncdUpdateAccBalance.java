package com.muks.oopsandjava.concepts.threads.concurrency.examples;

/**
 * Created by mukthar.ahmed on 11/1/15.
 */
public class SyncdUpdateAccBalance implements Runnable {
    private int balance;    // balance variable will be defaulted to 0

    @Override
    public void run() {
        for(int i = 0; i <= 20; i++) {
            accountUpdate();
        }
        System.out.println("+ Final balance = " + balance);
    }

    private void accountUpdate() {
    //private synchronized void accountUpdate() {
        synchronized (this) {
            int i = balance;
            balance = i + 1;
            System.out.println("Balance = " + balance);
        }
    }

    public static void main(String[] args) {
        SyncdUpdateAccBalance syncTester = new SyncdUpdateAccBalance();
        Thread one = new Thread(syncTester);
        Thread two = new Thread(syncTester);

        one.setName("Mike");
        two.setName("Molly");

        one.start();
        two.start();
    }
}
