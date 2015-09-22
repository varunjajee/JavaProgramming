package com.muks.oops.polymorphism;

/**
 * Created by mukthar.ahmed on 20/09/15.
 */
public class Animal {
    // Abstract class varialbes are protected so that its accessible by the extended class only.
    protected int id;
    protected String name;

    public void makeSound() {
        // some default implementation.
        System.out.println("...bhow bhow");
    }

    public void habitat() {
        // implementation
    }

}
