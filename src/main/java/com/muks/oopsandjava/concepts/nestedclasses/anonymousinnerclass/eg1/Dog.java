package com.muks.oopsandjava.concepts.nestedclasses.anonymousinnerclass.eg1;

/*
 * Created by mukthar.ahmed on 11/23/15.
 */
public class Dog extends Animal {
    public String name;

    public Dog(String dogName) {
        this.name = dogName;
    }

    public void bark() {
        System.out.println("Bhow bhow...");
    }


    public void run() {
        /*  Dog object property - run() is now overridden using anonymous class rather extending
             Animal class
         */
        Animal animalAnonymousClass = new Animal() {
            void run() {
                System.out.println("runs like a Dog");
            }
        };
        animalAnonymousClass.run();
    }

    public static void main(String[] args) {
        System.out.println("Dog ");
        Dog d = new Dog("Funny");
        d.run();
    }

}
