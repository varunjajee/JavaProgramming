package com.muks.oopsandjava.concepts.polymorphism;

/*
 * Created by mukthar.ahmed on 1/11/16.

    - Overloading of methods with varying return types is not allowed in java (c also)
    - Reason:
        - It causes a lot of ambiguity to the developers on which methods will be picked. Hence
        its restraint at java compiler level.
 */
public class ErrorOverloading {

    public class FirstClass {
        public int getID() {
            return 1;
        }
    }


    class SecondClass extends FirstClass {

        /* This is NOT allowed */
//        public String getID() {
//            return "10";
//        }


    }

}
