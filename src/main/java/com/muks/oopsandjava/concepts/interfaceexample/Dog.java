package com.muks.oopsandjava.concepts.Interfaceexample;

/*
 * Created by mukthar.ahmed on 11/18/15.
 */
public class Dog implements SampleAnimalInterface {
    @Override
    public void voice() {
        System.out.println("+ Bhow bhow.. ");
    }

    @Override
    public void animalType() {
        System.out.println("+ Am a pet animal");
    }

    @Override
    public boolean foreleged() {
        return true;
    }
}
