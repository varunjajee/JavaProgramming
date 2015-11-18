package com.muks.oops.reflection.example2;

/*
 * Created by mukthar.ahmed on 11/17/15.
 */
public class PrivateObjectClass {

    private String PRIVATE_FIELD = "Very private";

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
