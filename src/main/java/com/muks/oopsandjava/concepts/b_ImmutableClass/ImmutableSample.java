package com.muks.oopsandjava.concepts.b_ImmutableClass;

/**
 * Created by mukthar.ahmed on 3/1/16.
 *
 *  Creating a b_immutable class
 *
 *  How to make a b_immutable class:
    1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
    2. Make all fields final and private.
    3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
        - A more sophisticated approach is to make the constructor private and construct instances in factory methods.

    4. If the instance fields include references to mutable objects, don't allow those objects to be changed:

 */

/** final class, b_immutable as no other class can override itsimplementation*/
public final class ImmutableSample  {
    private static final String name = "Immutable-Sample-Name";     /** variable as private & static */

    private ImmutableSample() {   /** private constructor which will not allow to create class instance */
    }

    /** even internal methods are final */
    final public static String getName() {
        return name;
    }
}
