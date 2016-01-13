package com.muks.oopsandjava.concepts.polymorphism;

/*
 * Overloading - Static binding in javapack
 *          - Is a example of compile time polymorphism
 *          - Change in the number of variables/arguments or its data-type or its return type.
 *
 *     WHY  - Because, in case of overloading, at compile time the compiler knows which method to
  *          link to the call.
 */
public class Overloading_Compiletime_Poly {
    public int addValues() {
        int a = 1;
        int b = 2;
        return a + b;
    }

    public int addValues(int a, int b) {
        return a + b;
    }

    public float addValues(float a, float b) {
        return a+b;
    }


    /*
    Rules:
     - the return types can be difference
     - the method variables can be different

     - If only the return type is different, it's NOT a valid overload-the compiler will assume
        you're trying to override the method. And even that won't be legal unless the return type is
        a subtype of the return type declared in the superclass. To overload a method, you MUST
        change the argument list, although you can change the return type to anything.

          Eg:
            public float addValues (int a, int b) {
                float c = (float) 0.0;
                return c;
            }
     */
}
