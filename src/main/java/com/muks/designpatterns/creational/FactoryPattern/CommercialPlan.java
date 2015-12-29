package com.muks.designpatterns.creational.FactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */
public class CommercialPlan extends Plan {
    @Override
    public void getRate() {
        rate = 7.50;
    }
}
