package com.muks.oopsandjava.concepts.reflection.example2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * Created by mukthar.ahmed on 11/17/15.
 */
public class AccessingPrivate {
    public static void main(String[] args) {
        //no paramater
        Class noparams[] = {};

        //String parameter
        Class[] paramString = new Class[1];
        paramString[0] = String.class;

        //int parameter
        Class[] paramInt = new Class[1];
        paramInt[0] = Integer.TYPE;


        // How to access private methods during run time
        PrivateObjectClass privateObjClass = new PrivateObjectClass("The Private Value");

        try {
            // Accessing private method and set var value
            Method privateStrMethod =
                    PrivateObjectClass.class.getDeclaredMethod("setPrivateStringByValue",
                            String.class);

            System.out.println("+ Accessing Method: " + privateStrMethod.getName());
            privateStrMethod.setAccessible(true);
            privateStrMethod.invoke(privateObjClass, "Mukthar here.");

            // Accessing private getter method
            Method methodGetPrivateString =
                    PrivateObjectClass.class.getDeclaredMethod("getPrivateString", noparams);
            methodGetPrivateString.setAccessible(true);
            System.out.println("Method has over written value: " +
                    methodGetPrivateString.invoke(privateObjClass, null));


            // ###### Accessing private field from a class #######
            System.out.println("\n");

            // How to access private field
            //Field privateStringField = PrivateObjectClass.class.getDeclaredField("privateString");
            Field privateStringField = PrivateObjectClass.class.getDeclaredField("PRIVATE_FIELD");
            privateStringField.setAccessible(true); // change the accessibility to true

            String fieldValue = (String) privateStringField.get(privateObjClass);
            System.out.println("Existing value of field: " + fieldValue);

            privateStringField.set(privateObjClass, "new string value");
            System.out.println("fieldValue = " + fieldValue);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}   // end class
