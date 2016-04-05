package com.muks.trail_here;


import com.muks.oopsandjava.concepts.SingletonClassEx.SingletonSample;

class Testing {
    public static void main(String[] args) {
        SingletonSample singletonSample = SingletonSample.getInstance();
        SingletonSample singletonSample2 = SingletonSample.getInstance();

        System.out.println("# counter = " + singletonSample.getCounter() );
        System.out.println("# counter = " + singletonSample2.getCounter() );
    }

}