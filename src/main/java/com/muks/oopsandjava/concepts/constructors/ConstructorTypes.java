package com.muks.oopsandjava.concepts.constructors;

/**
 * Created by mukthar.ahmed on 1/11/16.
 */
public class ConstructorTypes {

    private double re, im;

    // A normal parametrized constructor
    public ConstructorTypes(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // This is how objects are cloned using "copy constructor" concept.
    // copy constructor
    ConstructorTypes(ConstructorTypes c) {
        System.out.println("Copy constructor called");
        re = c.re;
        im = c.im;
    }

    // Overriding the toString of Object class
    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }

    public static void main(String[] args) {
        ConstructorTypes type1 = new ConstructorTypes(1.0, 2.0);
        ConstructorTypes copyOf = new ConstructorTypes(type1);

        System.out.println("+ type-1 = " + type1.toString() );
        System.out.println("+ type-1 = " + copyOf.toString() );
    }

}
