package com.muks.oopsandjava.concepts.SingletonClassEx;

/**
 * Created by mukthar.ahmed on 3/1/16.
 */
public class TestingSingletonClass {

    public static void main(String[] args) {
        System.out.println(" - " + SingletonSample.getInstance().getName() );

        System.out.println(" - " + SingletonSample.getInstance().showMessage() );
    }
}
