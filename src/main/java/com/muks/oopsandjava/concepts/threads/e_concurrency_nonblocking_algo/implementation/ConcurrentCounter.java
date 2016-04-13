package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mukthar.ahmed on 4/4/16.
 */
public class ConcurrentCounter {
    public AtomicInteger value = new AtomicInteger();

    // getter
    public int getValue() {
         return value.get();
    }

    // setter
    public int incrementAndGet() {
        int v;

        do {
            v = getValue();
        }
        while ( !value.compareAndSet(v, v+1) );


        /** not of much interest */
        int rValue = v+1;
        System.out.println("Returning: " + rValue);


        return rValue;
    }
}
