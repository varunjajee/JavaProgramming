package com.muks.oopsandjava.concepts.h_nestedclasses.staticnested;

/**
 * Created by mukthar.ahmed on 11/23/15.
 */
class NonEnclosingClass {

    public static void main(String[] args) {
    /*instantiate the Nested class that is a static
      member of the EnclosingClass class:
    */

        EnclosingClass.Nested n = new EnclosingClass.Nested();
        n.someMethod();  //prints out "hello"
    }
}