package com.muks.DSC.LinkedList;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */
public abstract class LinkedList {
    public abstract void insertDefault(Object value);
    public abstract void deleteDefault();
    public abstract void deleteNode(int nodeValue);
    public abstract void deleteTail();

    /* print entire linked list */
    public abstract String toString();

}
