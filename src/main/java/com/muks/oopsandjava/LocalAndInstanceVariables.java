package com.muks.oopsandjava;

/*
 * Created by mukthar.ahmed on 17/09/15.
 *
 * Rules:
 * Local variables:
      Local variables do NOT get a default value
      The complier complains if you use variable before initializing it.

   Instance variables:
       They are outside a method and within the class scope.
       Eg: class Foo() below

 *
 */
public class LocalAndInstanceVariables {

    class Foo {
        private int size;
        public void setSize(int a) {
            size = a;
        }
    }


    public static void main(String[] args) {

    }

    public void localVariables() {
        int x;
        //int z = x + 3;    // If local variables are not initialised and just declared like x
        // then the complier chokes out hence assign value to it.
    }

    public void instanceVarialbles() {
        /*
        Instance varialbles are always out side of class and are mostly binded with the class
        scope as may be even private.
         */
    }
}
