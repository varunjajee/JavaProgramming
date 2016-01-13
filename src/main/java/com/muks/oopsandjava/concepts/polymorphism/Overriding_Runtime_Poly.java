package com.muks.oopsandjava.concepts.polymorphism;

/*
 * Polymorphism:
 *      Overriding / Dynamic binding in javapack
  *                 - is a example of run-time polymorphism
 *                  - It is the change in implementation of the methods
 *
 *                  - Dynamic (run time) polymorphism is the polymorphism existed at run-time.
 *                  Here, Java compiler does not understand which method is called at compilation
  *                  time. Only JVM decides which method is called at run-time.
 */
public class Overriding_Runtime_Poly {

    class Animal {
        public void whoAmI(){
            System.out.println("+ A generic animal...");
        }
    }

    class Dog extends Overriding_Runtime_Poly.Animal {
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
