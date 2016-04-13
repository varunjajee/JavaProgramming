package com.muks.oopsandjava.concepts.h_nestedclasses.localnested;

/**
 * Created by mukthar.ahmed on 1/19/16.
 * <p>
 * A class i.e. created inside a method is called local inner class in java. If you want to invoke the methods of
 * local inner class, you must instantiate this class inside the method.
 */

public class LocalNested {

    private void myMethod() {
        class local {
            void eat() {
                System.out.println("+ local class is eat() here.");
            }
        }

        local l = new local();
        l.eat();
    }

    public static void main(String[] args) {
        LocalNested ln = new LocalNested();
        ln.myMethod();
    }

}
