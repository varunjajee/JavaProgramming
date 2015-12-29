package com.muks.designpatterns.creational.FactoryPattern;

/**
 * Created by mukthar.ahmed on 12/27/15.
 */
public class DomensticPlan extends Plan {
    @Override
    public void getRate() {
        rate = 3.50;
    }
}
