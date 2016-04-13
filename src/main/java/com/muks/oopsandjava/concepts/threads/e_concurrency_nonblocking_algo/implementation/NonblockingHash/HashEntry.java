package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation.NonblockingHash;

/**
 * Created by mukthar.ahmed on 4/13/16.
 */
public class HashEntry {
    private int key;
    //private int value;
    volatile int value;
    public int hash;
    public HashEntry next;

    public HashEntry(int k, int v) {
        this.key = k;
        this.value = v;
        this.next = null;
    }

    public int getKey() { return this.key; }
    public int getValue() { return this.value; }
}
