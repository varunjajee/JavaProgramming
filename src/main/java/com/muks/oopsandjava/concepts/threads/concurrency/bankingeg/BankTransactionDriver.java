package com.muks.oopsandjava.concepts.threads.concurrency.bankingeg;

import com.muks.oopsandjava.concepts.threads.concurrency.racebysynchro.SynchronizationEgMikeAndMolyJob;

/*
 * Created by mukthar.ahmed on 11/1/15.
 *
 *  A race condition is a situation in which two or more threads or processes are reading or
 *  writing some shared name, and the final result depends on the timing of how the threads are
 *  scheduled. Race conditions can lead to unpredictable results and subtle program bugs
 *
 */
public class BankTransactionDriver {
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
