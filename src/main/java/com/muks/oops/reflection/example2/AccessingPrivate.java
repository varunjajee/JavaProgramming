package com.muks.oops.reflection.example2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * Created by mukthar.ahmed on 11/17/15.
 */
public class AccessingPrivate {
    public static void main(String[] args) {

        // How to access private methods during run time
        PrivateObjectClass privateObjClass = new PrivateObjectClass("The Private Value");
        try {

            Method privateStrMethod =
                    PrivateObjectClass.class.getDeclaredMethod("setPrivateStringByValue",
                            String.class);

            privateStrMethod.setAccessible(true);
            privateStrMethod.invoke(privateObjClass, "Mukthar here.");

            Method getPrivateStrMethod =
                    PrivateObjectClass.class.getDeclaredMethod("getPrivateString", null);
            privateStrMethod.setAccessible(true);

            String returnValue = null;
            returnValue = (String) getPrivateStrMethod.invoke(privateObjClass, null);
            System.out.println("returnValue = " + returnValue);


        } catch (Exception e) {
            e.printStackTrace();
        }



        // How to access private field
        Field privateStringField = null;
        try {
            privateStringField = PrivateObjectClass.class.getDeclaredField("privateString");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        privateStringField.setAccessible(true); // change the accessibility to true

        try {
            String fieldValue = (String) privateStringField.get(privateObjClass);
            System.out.println("fieldValue = " + fieldValue);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
