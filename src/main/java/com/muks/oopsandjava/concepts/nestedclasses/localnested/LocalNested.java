package com.muks.oopsandjava.concepts.nestedclasses.localnested;

/*
 * Created by mukthar.ahmed on 1/19/16.
 */

public class LocalNested {

    class local {
        void eat() {
            System.out.println("+ local class is eat() here.");
        }
    }


    public void accessingLocalNestedClass() {
        local l = new local();
        l.eat();
    }

    public static void main(String[] args) {
        LocalNested ln = new LocalNested();
        ln.accessingLocalNestedClass();
    }
}   // end main-class
