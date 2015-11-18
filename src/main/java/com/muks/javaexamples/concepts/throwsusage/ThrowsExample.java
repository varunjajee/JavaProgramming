package com.muks.javaexamples.concepts.throwsusage;

import java.io.IOException;

/*
 * Created by mukthar.ahmed on 11/17/15.
 */
public class ThrowsExample {

    static void mymethod(int num) throws IOException, ClassNotFoundException{
        if(num==1)
            throw new IOException("Custom Exception Message1");
        else
            throw new ClassNotFoundException("Custom Exception Message2");
    }


    // Testing sub-class
    public static class Testing {
        public static void main(String[] args) {
            try {
                ThrowsExample.mymethod(10);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            } finally {
                System.out.println("+ INFO: Finally executes irrespective of exception.");
            }
        }
    }

}


