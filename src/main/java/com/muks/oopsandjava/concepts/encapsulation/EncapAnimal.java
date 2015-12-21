package com.muks.oopsandjava.concepts.encapsulation;

/**
 * To achieve encapsulation in Java
     Declare the variables of a class as private.
     Provide public setter and getter methods to modify and view the variables values.

 * Benefits of Encapsulation:
     The fields of a class can be made read-only or write-only.
     A class can have total control over what is stored in its fields.
     The users of a class do not know how the class stores its data. A class can change the data
    type of a field and users of the class do not need to change any of their code.

 */
public class EncapAnimal {
    private String animalName;
    private String animalBehaviour;
    private int ageOfAnimal;

    public int getAge(){
        return ageOfAnimal;
    }

    public String getName(){
        return animalName;
    }

    public void setAge( int newAge){
        ageOfAnimal = newAge;
    }

    public void setName(String newName){
        animalName = newName;
    }

}
