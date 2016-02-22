package com.muks.oopsandjava.concepts.nestedclasses.anonymousinnerclass.eg1;

/*
 * Created by mukthar.ahmed on 11/23/15.
 */

public class AnonymousEg2 {

    public static void main(String[] args) {
        Dog dg = new Dog("blogger");
        dg.run();

    /*
        A general usage of Animal() class object returns compilation error.

        Animal d = new Animal();
        d.bark();    - gives compilation error since bark() is not defined in Animal() class
    */

    }

}
