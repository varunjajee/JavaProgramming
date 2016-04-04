package com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mukthar.ahmed on 4/4/16.
 */
public class NonblockingCounter {
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
        while ( !value.compareAndSet(v, v+1));

        int rValue = v+1;
        System.out.println("Returning: " + rValue);
        return rValue;
    }
}
