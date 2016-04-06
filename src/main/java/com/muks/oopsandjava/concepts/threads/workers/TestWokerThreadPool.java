package com.muks.oopsandjava.concepts.threads.workers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mukthar.ahmed on 3/2/16.
 */
public class TestWokerThreadPool {
    public static void main(String[] args) {

        // creating a thread pool - a.k.a worker pool, where workers perform given task and get back to pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 15; i++) {
            Thread workerThread = new Thread(new MyWorkerThread());

            workerThread.setName("Thread-" + i);
            executorService.execute(workerThread);
        }

        if (executorService.isShutdown()) {
            System.out.println("+ Successfully, has shutdown all workers");
        }
    }
}
