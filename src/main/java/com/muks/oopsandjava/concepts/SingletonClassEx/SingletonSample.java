package com.muks.oopsandjava.concepts.SingletonClassEx;

/**
 * Created by mukthar.ahmed on 3/1/16.
 *
 *  - defining singleton class
 */
public class SingletonSample {
    private static final String NAME = "SingletonSample-Name";
    private static int counter;

    private SingletonSample() {}

    private static SingletonSample instance;

    public static SingletonSample getInstance() {
        /** Its important to check if no previous instance of the class exists */
        if (instance == null) {
            ++counter;                  /** proof that the class is instantiated only for once */
            instance = new SingletonSample();
        }

        return instance;
    }

    public int getCounter() { return counter; }

}
