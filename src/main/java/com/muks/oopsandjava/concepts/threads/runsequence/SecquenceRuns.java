package com.muks.oopsandjava.concepts.threads.runsequence;

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

        //try {
            t1.start();
            //t1.join();

            t2.start();
         //   t2.join();

            t3.start();
           // t3.join();


//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void run() {
        System.out.println("+ Name = " + Thread.currentThread().getName() + " is on....");
    }
}
