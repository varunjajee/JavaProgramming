package com.muks.oopsandjava.concepts.nestedclasses.staticnested;

/**
 * Created by mukthar.ahmed on 11/23/15.
 */

abstract class Person{
    abstract void eat();
}

class TestAnonymousInner {
    public static void main(String args[]){
        Person p = new Person(){
            void eat(){
                System.out.println("nice fruits");}
        };
        p.eat();
    }
}