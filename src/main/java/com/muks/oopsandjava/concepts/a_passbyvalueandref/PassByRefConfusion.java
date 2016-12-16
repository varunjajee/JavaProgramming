package com.muks.oopsandjava.concepts.a_passbyvalueandref;

/* Java is always - pass-by-value

    - http://www.javaranch.com/campfire/StoryPassBy.jsp    - Used in the below example

    Points to remember:
        -   int xMethod = 3;
        -   int y = xMethod;
            -> java is copying the value of 'xMethod' to 'y'
            -> instead of creating a new variable, java creates a copy of the reference.

        Dog d = new Dog("funny");
        Dog a = d;

            -> The reference of 'd' is passed by even the reference is passed by value.
            -> The value of the reference 'd' is passed and stored in 'a'
 */
public class PassByRefConfusion {

    public static void main(String args[]) {
        // Eg-1
        int x = 3;
        int y = x;

        System.out.println("+ xMethod = " + x + ", y = " + y);


        // Eg-2
        Dog d1 = new Dog("funny");
        Dog d2 = d1;
        System.out.println("==== " +System.identityHashCode(d1) + ", d1=" + d1.name);
        System.out.println("==== " +System.identityHashCode(d2) + ", d2=" + d2.name);

        d2 = new Dog("boxer");
        System.out.println("==== " +System.identityHashCode(d2) + ", d2=" + d2.name);

    }


    // Dog class
    static class Dog {
        String name;

        Dog(String name) {
            this.name = name;

        }
    }

}
