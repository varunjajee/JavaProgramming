package com.muks.oopsandjava.concepts.threads.ThreadRunSequence;

import java.util.Random;

/*
 * Created by mukthar.ahmed on 1/21/16.
 *
 *  Sequencing of thread execution is depending on t.join() which also throws "InterruptedException"
 *
 */
public class SecquenceRuns extends Thread {

    public static void main(String[] args) {
        SecquenceRuns sequenceRuns = new SecquenceRuns();

        final Thread t1 = new Thread(sequenceRuns); // assume T1 is a Runnable
        t1.setName("1st Thread");

        final Thread t2 = new Thread(sequenceRuns);
        t2.setName("2nd Thread");

        final Thread t3 = new Thread(sequenceRuns);
        t3.setName("3rd Thread");

        //TestingBlockingAlgo {
            //t1.start();
        try {
            t1.start();

            t1.join();
            t2.start();

            t2.join();
            t3.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //t2.start();
         //   t2.join();

          //  t3.start();
           // t3.join();


//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

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
