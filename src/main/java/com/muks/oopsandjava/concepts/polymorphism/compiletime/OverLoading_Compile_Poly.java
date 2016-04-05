package com.muks.oopsandjava.concepts.polymorphism.compiletime;

/*
 * Overloading - Static binding in javapack
 *          - Is a example of compile time polymorphism
 *          - Change in the number of variables/arguments or its name-type or its return type.
 *
 *     WHY  - Because, in case of overloading, at compile time the compiler knows which method to
  *          link to the call.
 */
public class OverLoading_Compile_Poly {
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
    }       /** Return type is a sub-class of int */
    public Integer add (Integer a, int b) { return (a+b); }        /** Integer */

    public int add (int a, int b) { return (a+b); }                /** Vary in number of method args */
    public int add (int a, int b, int c) {return (a+b+c); }

    public static void main(String[] args) {
        System.out.println("+ 1st = " + new OverLoading_Compile_Poly().add(1, 2, 3) );
        System.out.println("# 2nd = " + new OverLoading_Compile_Poly().add(1, 2) );
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
