package com.muks.oopsandjava.concepts.threads.aaa_run_call_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by mukthar.ahmed on 4/6/16.
 * <p>
 * http://javahungry.blogspot.com/2015/05/implements-runnable-vs-extends-thread-in-java-example.html
 * <p>
 * <p>
 * Note: "implements runnable" is preferred over "extends Thread"
 * <p>
 * 1. Function overhead : Thread class loads whole lot of functions which are not generally used
 * <p>
 * 2. Inheritance option: Once we "extend Thread" class, we cannot extend any more as java allows extending only 1
 * class and doesn't support multiple inheritance via classes rather interfaces.
 */
public class RunnableEg implements Runnable {
    String name;

    RunnableEg(String name) {
        //Thread.currentThread().setName(name);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            long sleepInterval = new Random().nextInt(500) + 501;
            System.out.println("# sleeping for - " + sleepInterval);
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("# " + name + ", " + Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future> allThreads = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new RunnableEg("muks-" + i);
            Future runnableTask = executorService.submit(runnable);
            allThreads.add(runnableTask);
        }

        executorService.shutdownNow();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MICROSECONDS)) {
                System.out.println("Still waiting after 100ms: calling System.exit(0)...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting normally...");

        for (Future futureThread : allThreads) {
            while (true) {
                if ( futureThread.isDone() ) {
                    break;
                }
            }
        }

    }

}
