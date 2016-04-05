package com.muks.oopsandjava.concepts.SingletonClassEx;


/**
 * Created by mukthar.ahmed on 3/1/16.
 *  - Testing singleton class instance
 */
public class TestingSingletonClass {

    public static void main(String[] args) {
        SingletonSample singletonSample1 = SingletonSample.getInstance();
        SingletonSample singletonSample2 = SingletonSample.getInstance();

        System.out.println( "# From instance # 1 : " + singletonSample1.getCounter() );
        System.out.println( "# From instance # 2 : " + singletonSample2.getCounter() );
    }
}
