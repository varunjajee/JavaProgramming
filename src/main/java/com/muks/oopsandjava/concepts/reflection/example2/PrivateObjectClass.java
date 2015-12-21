package com.muks.oopsandjava.concepts.reflection.example2;

/*
 * Created by mukthar.ahmed on 11/17/15.
 */
public class PrivateObjectClass {

    private String PRIVATE_FIELD = "Very private";
    private int PRIVATE_INT_FIELD = 1000;

    public PrivateObjectClass(int intField) { this.PRIVATE_INT_FIELD = intField; }

    public PrivateObjectClass(String PRIVATE_FIELD) {
        this.PRIVATE_FIELD = PRIVATE_FIELD;
    }

    private String getPrivateString(){
        return this.PRIVATE_FIELD;
    }

    private void setPrivateStringByValue(String anotherPrivateString) {
        this.PRIVATE_FIELD = anotherPrivateString;
    }

}
