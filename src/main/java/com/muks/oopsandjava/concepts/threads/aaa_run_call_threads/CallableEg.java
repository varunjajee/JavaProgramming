package com.muks.oopsandjava.concepts.threads.aaa_run_call_threads;

import java.util.concurrent.Callable;

/**
 * Created by mukthar.ahmed on 4/6/16.
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
}
