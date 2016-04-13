package com.muks.oopsandjava.concepts.f_polymorphism.runtime;

/**
 * Runtime or method overriding or dynamic f_polymorphism
 *
 *  - Here, Java compiler does not understand which method is called at compilation time.
 *  Only JVM decides which method is called at run-time.
 */
public class OverRiding_Runtime_Dynamic_Poly {

    class Animal {
        public void whoAmI(){
            System.out.println("+ A generic animal...");
        }
    }

    class Dog extends OverRiding_Runtime_Dynamic_Poly.Animal {
        public void whoAmI(){
            System.out.println("+ Am a Dog...");
        }
    }

    class Cat extends Animal {
        public void whoAmI(){
            System.out.println("+ Am a Cat...");
        }
    }

    /** runtime f_polymorphism # 1
     *  -   where jvm decides which method to call based on type of object, the reference variable holds.
     */
    void execRuntime() {
        Animal ref1 = new Animal();
        Animal ref2 = new Dog();
        Animal ref3 = new Cat();

        ref1.whoAmI();
        ref2.whoAmI();
        ref3.whoAmI();
    }


    /**
        Polymorphism # 2
        Animal myDog = new Dog();       // up-casting object also known as runtime f_polymorphism
     */
    public static void main(String[] args) {
        OverRiding_Runtime_Dynamic_Poly runtime = new OverRiding_Runtime_Dynamic_Poly();
        runtime.execRuntime();
    }
}
