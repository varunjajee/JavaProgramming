package com.muks.oopsandjava.concepts.threads.c_ThreadRunSequence;

import java.util.Random;

/*
 * Created by mukthar.ahmed on 1/21/16.
 *
 *  Sequencing of thread execution is depending on t.join() which also throws "InterruptedException"
 *
 */
public class ByJoins extends Thread {

    public static void main(String[] args) {
        ByJoins sequenceRuns = new ByJoins();

        final Thread t1 = new Thread(sequenceRuns); // assume T1 is a Runnable
        t1.setName("1st Thread");

        final Thread t2 = new Thread(sequenceRuns);
        t2.setName("2nd Thread");

        final Thread t3 = new Thread(sequenceRuns);
        t3.setName("3rd Thread");


        try {
            t1.start();

            t1.join();      /** Waits for this thread to die. */
            t3.start();

            t3.join();
            t2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        RandomThreadSleep();
        System.out.println("+ Name = " + Thread.currentThread().getName() + " is on....");
    }

    public void RandomThreadSleep() {
        try {
            Thread.sleep(new Random().nextInt(1000) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
