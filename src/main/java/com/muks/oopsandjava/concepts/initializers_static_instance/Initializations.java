package com.muks.oopsandjava.concepts.initializers_static_instance;

/*
 * Created by mukthar.ahmed on 1/11/16.
 */
public class Initializations {
    static int staticCounter;
    int nonStaticCounter;

    Initializations() {
        System.out.println("# 3: Initializations() class constructor being called.\n");
        staticCounter++;
        nonStaticCounter++;
    }


    static {
        System.out.println("# 1: Static initializer being called");
    }

    // instance initialization
    {
        System.out.println("# 2: Instance - initialization.");
    }


    public static void main(String[] args) {
        Initializations myinit1 = new Initializations();
        Initializations myinit2 = new Initializations();
        Initializations myinit3 = new Initializations();
        Initializations myinit4 = new Initializations();

        System.out.println("+ Static variable (Counter) = " + Initializations.staticCounter
                + ", Non-Static variable = " + myinit4.nonStaticCounter);
    }
}
