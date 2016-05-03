package com.muks.oopsandjava.concepts.e_initializers_static_instance;

/**
 * Created by mukthar.ahmed on 1/11/16.
 *
 * Initializer:
 *
 *      - Static initializer executes for once per all instances
 *      - Non-static (which is instance initializer), executes for every instance initialization
 *      - Constructor, executes for all instance initializations.
 *
 *
 *  Sequence:
 *      1 - Static
 *      2 - Non-static / instance
 *      3 - Constructors
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
