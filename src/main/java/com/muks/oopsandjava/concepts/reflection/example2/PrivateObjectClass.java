package com.muks.oopsandjava.concepts.reflection.example2;

/*
 * Created by mukthar.ahmed on 11/17/15.
 */
public class PrivateObjectClass {

    private String PRIVATE_STRING_FIELD = "Very private";
    private int PRIVATE_INT_FIELD = 1000;

    // constructor - 1
    public PrivateObjectClass() {
        System.out.println("+ Original value of \"PRIVATE_STRING_FIELD\": " + PRIVATE_STRING_FIELD
        + " & value of \"PRIVATE_INT_FIELD\": " + PRIVATE_INT_FIELD);
    }


    // private methods
    private String getPrivateString(){
        return this.PRIVATE_STRING_FIELD;
    }

    private void setPrivateStringByValue(String anotherPrivateString) {
        this.PRIVATE_STRING_FIELD = anotherPrivateString;
    }



    // for testing purpose
    public String getPrivateFieldStringForTesting() { return PRIVATE_STRING_FIELD; }
    public int getPrivateIntField() { return PRIVATE_INT_FIELD; }

}
