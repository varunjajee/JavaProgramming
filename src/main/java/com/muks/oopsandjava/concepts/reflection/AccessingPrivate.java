package com.muks.oopsandjava.concepts.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by mukthar.ahmed on 11/17/15.
 *
 *      - Accessing private class members
 */

public class AccessingPrivate {
    public static void main(String[] args) {
        MyPrivateClass testing = new MyPrivateClass();


        try {
            System.out.println("# Name Before = " + testing.getName() );

            /** Accessing private field, String type */
            Field name = MyPrivateClass.class.getDeclaredField("name");
            name.setAccessible(true);
            name.set(testing, "ahmed");

            System.out.println("# Name After = " + testing.getName() );

            /** Accessing private field, int type */
            Field privateInt = MyPrivateClass.class.getDeclaredField("counter");
            privateInt.setAccessible(true);
            System.out.println("# Direct access of private int variable " + privateInt.get(testing) );


            /** Accessing private method, int arg type */
            Method counter = MyPrivateClass.class.getDeclaredMethod("incrementCounter", int.class);
            counter.setAccessible(true);
            counter.invoke(testing, 10);
            System.out.println("# After reflection = " + testing.getCounter() );


            /** Accessing private method, String arg type */
            Method setNameMethod = MyPrivateClass.class.getDeclaredMethod("setName", String.class);
            setNameMethod.setAccessible(true);
            setNameMethod.invoke(testing, "Ahmedii");
            System.out.println("# After reflection = " + testing.getName() );


            /** method with no args */
            Method noArgs = MyPrivateClass.class.getDeclaredMethod("autoIncrement", null);
            noArgs.setAccessible(true);
            noArgs.invoke(testing, null);
            System.out.println("# Counter after reflection = " + testing.getCounter() );


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}   // end class
