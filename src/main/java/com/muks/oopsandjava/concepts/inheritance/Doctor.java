package com.muks.oopsandjava.concepts.inheritance;

/**
 * Created by mukthar.ahmed on 17/09/15.
     * Interface
     •	Interfaces are implicitly abstract and cannot have implementations.
     •	Variables declared here are always final variables.
     •	Keyword here is “Interface”
     •	Eg:
         Public interface Drawable {
         // implicit abstraction
         }

     Abstract Class
     •	Can have default behavior implementations here.
        An abstract class can NOT be instantiated.
        Its useless unless its extended and implemented for its overriden methods
     •	May contain non-final variables too.
     •	Eg:
         Public abstract class Drawable {
         // abstraction or default implementation
         }

 */
public class Doctor {
    // Abstract class varialbes are protected so that its accessible by the extended class only.
    protected boolean worksAtHospital = false;

    void treatPatient() {
        // perform checkup and its type

    }
}
