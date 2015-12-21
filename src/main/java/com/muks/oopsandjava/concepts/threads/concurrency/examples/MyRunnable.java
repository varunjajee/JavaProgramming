package com.muks.oopsandjava.concepts.threads.concurrency.examples;

/*
 * Created by mukthar.ahmed on 10/31/15.
 *
 * Example on how unpredictable the thread scheduler can be
 *
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        String threadName = Thread.currentThread().getName();   // access thread name
        System.out.println("Thread Name: " + threadName
                        + ", Top of the stack - from " + MyRunnable.class.getName());
    }
}
