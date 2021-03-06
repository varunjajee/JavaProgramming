package com.muks.oopsandjava.concepts.d_inheritance.dimondproblem;

/**
 * Created by mukthar.ahmed on 10/7/15.
 */
public class Dog implements PetInterface, CanineInterface{


    /*
    Note:
    - All methods defined in Interface have to implemented mandatory which also avoides Dimond-Problem
    - Abstract class may not enforce method implementation

    - Multiple Interfaces can be implemented but extend only one class

    How do you know whether to make a class, a subclass, an abstract class, or an interface?
     - Make a class that doesn’t extend anything (other than Object) when your new class doesn’t pass the IS-A test for any other type.
    -  Make a subclass (in other words, extend a class) only when you need to make a more specific version of a class and need to override or add new behaviors.
    -  Use an abstract class when you want to define a template for a group of subclasses, and you have at least some implementation code that all subclasses could use. Make the class abstract when you want to guarantee that nobody can make objects of that type.
    -  Use an interface when you want to define a role that other classes can play, regardless of where those classes are in the d_inheritance tree.

    */
    @Override
    public void beFriendly() {

    }

    @Override
    public void play() {

    }

    @Override
    public void teeth() {   // => this method comes from CanineInterface.javapack

    }
}
