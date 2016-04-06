package com.muks.oopsandjava.concepts.threads.aaa_run_call_threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mukthar.ahmed on 4/6/16.

 * - Callable example
 *
 */

public class CallableEg implements Callable {

    ThreadLocal<Integer> counter = new ThreadLocal<>();

    CallableEg(String name) {
        Thread.currentThread().setName(name);
    }

    @Override
    public Integer call() throws Exception {
        int val = counter.get();
        return ++val;
    }



    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            Callable callable = new CallableEg("muks-" + i);
            executorService.submit(callable);
        }

        executorService.shutdown();
    }
}
