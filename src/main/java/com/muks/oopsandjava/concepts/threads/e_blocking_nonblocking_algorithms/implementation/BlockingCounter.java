package com.muks.oopsandjava.concepts.threads.e_blocking_nonblocking_algorithms.implementation;

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

