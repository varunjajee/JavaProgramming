package com.muks.oopsandjava.concepts.threads.a_runnable_callable_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by mukthar.ahmed on 4/6/16.

 * http://javahungry.blogspot.com/2015/05/implements-runnable-vs-extends-thread-in-java-example.html

 * Note: "implements runnable" is preferred over "extends Thread"

 * 1. Function overhead : Thread class loads whole lot of functions which are not generally used

 * 2. Inheritance option: Once we "extend Thread" class, we cannot extend any more as java allows extending only 1
 * class and doesn't support multiple d_inheritance via classes rather interfaces.
 */
public class RunnableEg implements Runnable {
    String name;

    RunnableEg(String name) {
        //Thread.currentThread().setName(name);
        this.name = name;
    }

    @Override
    public void run() {
        long sleepInterval = 0l;
        try {
            sleepInterval = new Random().nextInt(1000) + 10;
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        System.out.println("# sleept for - \"" + sleepInterval + "\", " + name + ", " + Thread.currentThread().getName
            ());
    }




    /** Main method */
    public static void main(String[] args) {
        /** create a thread pool of 10 and submit workers */
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future> allThreads = new ArrayList<>();    /** track all submitted threads */

        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new RunnableEg("muks-" + i);    /** thread class instance */
            Future runnableTask = executorService.submit(runnable);
            allThreads.add(runnableTask);
        }



        executorService.shutdown();     /** Like graceful shutdown. Waits till all threads are completed. */
        //executorService.shutdownNow();  /** Like "kill -9" no more threads can be added to the thread pool */

//        /** Approach # 1 : To wait till all threads are completed */
//        try {
//            if (!executorService.awaitTermination(1000, TimeUnit.MICROSECONDS)) {
//                System.out.println("Still waiting after 100ms: calling System.exit(0)...");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Exiting normally...");


        /** Approach # 2 : To wait till all threads are completed */
        for (Future futureThread : allThreads) {
            while (true) {
                if ( futureThread.isDone() ) {
                    break;
                }
            }
        }

    }

}
