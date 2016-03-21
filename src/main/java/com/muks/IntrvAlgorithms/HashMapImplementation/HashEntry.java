package com.muks.IntrvAlgorithms.HashMapImplementation;

/**
 * Created by mukthar.ahmed on 3/18/16.
 */
public class HashEntry {

    private int key, value;

    public HashEntry(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        this.value = val;
    }
}
