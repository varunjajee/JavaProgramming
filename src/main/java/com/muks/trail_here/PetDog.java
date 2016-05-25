package com.muks.trail_here;

/**
 * Created by mukthar.ahmed on 5/15/16.
 */
public class PetDog extends Dog {

    PetDog(String myName) {
        super(myName);
    }



    public void eat() {

        System.out.println("# Pet food.");
    }

    public void move() {
        System.out.println("# ");
    }
}
