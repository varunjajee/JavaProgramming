package com.muks.designpatterns.creational.FactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */


abstract class Plan {
    protected double rate;  // this value will be set during runtime by the instantiated class

    abstract void getRate();    // this is abstract and its implementation is again during runtime

    public void calculateBill(int units) {
        System.out.println("Bill amounts to: " + units * rate);
    }

}
