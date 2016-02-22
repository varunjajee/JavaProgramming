package com.muks.designpatterns.creational.AbstractFactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */
abstract class AbstractFactory {
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}
