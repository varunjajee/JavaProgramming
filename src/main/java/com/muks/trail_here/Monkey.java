package com.muks.trail_here;

/**
 * Created by mukthar.ahmed on 5/15/16.
 */
public class Monkey implements Animal {
    @Override
    public void eat() {
        System.out.println("# Eats fruits only..");
    }

    @Override
    public void move() {
        System.out.println("# Moves by 2 legs... ");
    }
}
