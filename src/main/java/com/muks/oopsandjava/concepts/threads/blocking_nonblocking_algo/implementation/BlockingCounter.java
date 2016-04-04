package com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation;

/** Thread safe, blocking counter implementation */
public class BlockingCounter {
    public int value = 0;

    // getter
    public synchronized int getValue() {
        return value;
    }

    // setter
    public synchronized int incrementAndGet() {
        return ++value;
    }
}


