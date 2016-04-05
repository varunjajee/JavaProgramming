package com.muks.oopsandjava.concepts.reflection;

/**
 * Created by mukthar.ahmed on 11/17/15.
 *
 *  - class which is completely encapsulated with private objects
 */

class MyPrivateClass {
    private String name = "muks";
    private int counter = 1;

    String getName() { return name; }
    int getCounter() { return counter; }

    private void incrementCounter(int val) { counter += val; }

    private void setName(String val) { this.name = val; }

    private int autoIncrement() {
        return ++counter;
    }
}
