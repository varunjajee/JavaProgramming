package com.muks.designpatterns.creational.AbstractFactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */
public class ICICIBank implements Bank {
    @Override
    public String getBankName() {
        return "ICICI Bank";
    }
}
