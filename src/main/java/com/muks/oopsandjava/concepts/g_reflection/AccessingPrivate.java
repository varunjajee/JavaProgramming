package com.muks.oopsandjava.concepts.g_reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mukthar.ahmed on 11/17/15.
 *
 *      - Accessing private class members
 */

public class AccessingPrivate {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
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


            /** modifying the private variable */
            privateInt.set(testing, 10);


            /** Accessing private method, int arg type */
            Method counter = MyPrivateClass.class.getDeclaredMethod("incrementCounter", Integer.class);
            counter.setAccessible(true);
            counter.invoke(testing, 10);
            System.out.println("# After g_reflection = " + testing.getCounter() );


            /** Accessing private method, String arg type */
            Method setNameMethod = MyPrivateClass.class.getDeclaredMethod("setName", String.class);
            setNameMethod.setAccessible(true);
            setNameMethod.invoke(testing, "Ahmedii");
            System.out.println("# After g_reflection = " + testing.getName() );


            /** method with no args */
            Method noArgs = MyPrivateClass.class.getDeclaredMethod("autoIncrement", null);
            noArgs.setAccessible(true);
            noArgs.invoke(testing, null);
            System.out.println("# Counter after g_reflection = " + testing.getCounter() );


        } catch (NoSuchMethodException  | NoSuchFieldException e) {
            e.printStackTrace();

        }
    }

}   // end class
