package com.muks.oopsandjava.concepts.h_nestedclasses.staticnested;

/**
 * Created by mukthar.ahmed on 11/23/15.
 */
class EnclosingClass {
    static class Nested {
        void someMethod() { System.out.println("hello"); }

        void anotherMethod() {
            System.out.println("hi again");
        }
    }

    public static void main(String[] args) {
    //access enclosed class:
        Nested n = new Nested();
        n.anotherMethod();  //prints out "hi again"
    }


}
