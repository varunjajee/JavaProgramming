package com.muks.oopsandjava.concepts.ImmutableClass;

/**
 * Created by mukthar.ahmed on 3/1/16.
 *
 *  Creating a immutable class
 *
 *  How to make a immutable class:
    1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
    2. Make all fields final and private.
    3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
        - A more sophisticated approach is to make the constructor private and construct instances in factory methods.

    4. If the instance fields include references to mutable objects, don't allow those objects to be changed:

 */

final public class ImmutableSample  {
    private static final String name = "Immutable-Sample-Name";

    private ImmutableSample() {   // private constructor which will not allow to instantiate
    }

    public static String getName() {
        return name;
    }
}
