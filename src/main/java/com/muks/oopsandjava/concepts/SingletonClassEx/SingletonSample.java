package com.muks.oopsandjava.concepts.SingletonClassEx;

/**
 * Created by mukthar.ahmed on 3/1/16.
 */
public class SingletonSample {
    private static final String NAME = "SingletonSample-Name";

    private SingletonSample() {}

    private static SingletonSample instance = new SingletonSample();

    public static SingletonSample getInstance() {
        return instance;
    }

    public String getName() {
        String str = "abc";
        str.length();
        return NAME;

    }

    public String showMessage() { return "+ Testing showMessage() "; }
}
