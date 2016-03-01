package com.muks.oopsandjava.concepts.ClassSingleton;

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
        return NAME;
    }

    public String showMessage() { return "+ Testing showMessage() "; }
}
