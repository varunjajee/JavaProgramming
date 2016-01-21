package com.muks.oopsandjava.concepts.threads.misc;

/*
 * Created by mukthar.ahmed on 10/31/15.
 *
 * Example on how unpredictable the thread scheduler can be
 *
 */
public class ThreadsTestDrive {

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);

//        myThread.start();
//        System.out.println("+ Back in main, done with starting the thread.");

        Thread alphaThread = new Thread(myRunnable);
        Thread betaThread = new Thread(myRunnable);

        alphaThread.setName("Alpha Thread");
        betaThread.setName("Beta Thread");
        alphaThread.start();
        betaThread.start();
    }
}
