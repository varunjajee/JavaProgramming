package com.muks.headfirstjava.threads.concurrency;

import com.muks.headfirstjava.threads.concurrency.racebysynchro.SynchronizationEgMikeAndMolyJob;

/*
 * Created by mukthar.ahmed on 11/1/15.
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
