package com.muks.oops.polymorphism;

/**
 * Created by mukthar.ahmed on 20/09/15.
 */
public class Overriding_Runtime_Poly {

    class Animal {
        public void whoAmI(){
            System.out.println("+ A generic animal...");
        }
    }

    class Dog extends com.muks.oops.polymorphism.Overriding_Runtime_Poly.Animal {
        public void whoAmI(){
            System.out.println("+ Am a Dog...");
        }
    }

    class Cat extends Animal {
        public void whoAmI(){
            System.out.println("+ Am a Cat...");
        }
    }

    /*
    JVM determines what method is to be executed during the runtime based on what the type of
    object, the reference variable holds.
     */
    public void execRuntime() {
        Animal ref1 = new Animal();
        Animal ref2 = new Dog();
        Animal ref3 = new Cat();

        ref1.whoAmI();
        ref2.whoAmI();
        ref3.whoAmI();
    }

    public static void main(String[] args) {
        Overriding_Runtime_Poly runtime = new Overriding_Runtime_Poly();
        runtime.execRuntime();

    }
}
