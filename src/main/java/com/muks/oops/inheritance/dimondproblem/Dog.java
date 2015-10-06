package com.muks.oops.inheritance.dimondproblem;

/**
 * Created by mukthar.ahmed on 10/7/15.
 */
public class Dog extends AnimalClass implements PetInterface, CanineInterface{


    /*
    Note:
    - All methods defined in Interface have to implemented mandatory which also avoides Dimond-Problem
    - Abstract class may not enforce method implementation

    - Multiple Interfaces can be implemented but extend only one class
    */
    @Override
    public void beFriendly() {

    }

    @Override
    public void play() {

    }

    @Override
    public void teeth() {   // => this method comes from CanineInterface.java

    }
}
