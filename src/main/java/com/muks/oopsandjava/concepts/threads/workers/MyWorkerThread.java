package com.muks.oopsandjava.concepts.threads.workers;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mukthar.ahmed on 3/2/16.
 */
public class MyWorkerThread implements Runnable {
    private static String threadName;


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - has started!");

        // sleep for random frequency picked between 500 to 1000
        try {
            Thread.sleep(new Random().nextInt(500) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(Thread.currentThread().getName() + " - is ending...");
    }
}
