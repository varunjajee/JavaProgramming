package com.muks.threads;

/*
 * Topics covered:
 * - Thread safety
 * - ThreadLocal
 * - When and how to use ThreadLocal
 *  - Link: http://www.journaldev.com/1076/java-threadlocal-example-to-create-thread-local-variables
 *
 *  Difference between thread and process:
 *  - https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html
 *  - http://java67.blogspot.in/2012/12/what-is-difference-between-thread-vs-process-java.html
 */

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalAndThreadSafety implements Runnable{

    // SimpleDateFormat is not thread-safe, so give one to each thread
    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HHmm");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalAndThreadSafety threadObj = new ThreadLocalAndThreadSafety();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(threadObj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }


    public void run() {
        System.out.println("\nThread Name = " + Thread.currentThread().getName() +
            ", Default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name = " + Thread.currentThread().getName() +
            ", Formatter = " + formatter.get().toPattern() );
    }

}
