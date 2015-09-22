package com.muks.oops.polymorphism;

/**
 * Created by mukthar.ahmed on 20/09/15.
 */
public class AnimalDefinitions extends Animal {
    /*
    polymorphism # 1
     This is one type of polymorphism where reference type of a subclass can be of its super
     class type.
     */
    Animal myDog = new Dog();


    /*
    polymorphism # 2
    A method argument can be of its superclass object type consuming subclass object reference too
     */

    /*
    polymorphism # 3 (Shown in the method Foo()
    Since the JVM decides what method to pick based on the type of object what the reference holds,
    its all during runtime and hence runtime polymorphism
    */
    public void giveAShot(Animal a) {
//        a.name = "Funny";
        System.out.println("+ Name: " + name);
    }

    /* What can you do with polymorphism
    - With it, you can write code which doesn't have to change when you introduce new subclass
     */

    public void foo() {
        Dog dd = new Dog();
        AnimalDefinitions ad = new AnimalDefinitions();
        ad.giveAShot(dd);
    }

    class Dog extends Animal {
        private String name;
        String type;
        void whoAmI() {
            System.out.println("I am a Dog.");
        }

        public void dogName() {
            this.name = "don";
        }
    }

    class Animal {
        void whoAmI() {
            System.out.println("I am a generic Animal.");
        }
    }


    class Cow extends Animal {
        void whoAmI() {
            System.out.println("I am a Cow.");
        }
    }
    class Snake extends Animal {
        void whoAmI() {
            System.out.println("I am a Snake.");
        }
    }


    public static void main(String[] args) {
        AnimalDefinitions ad = new AnimalDefinitions();
        ad.Foo();
    }

    public void Foo() {

        Animal ref1 = new Animal();
        Animal ref2 = new Dog();
        Animal ref3 = new Cow();
        Animal ref4 = new Snake();
        ref1.whoAmI();
        ref2.whoAmI();
        ref3.whoAmI();
        ref4.whoAmI();
    }

}
