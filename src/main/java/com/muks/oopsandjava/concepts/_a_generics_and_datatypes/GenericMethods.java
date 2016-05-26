package com.muks.oopsandjava.concepts._a_generics_and_datatypes;

/**
 * Created by mukthar.ahmed on 5/27/16.

    Topic: Java generic methods

    Eg-1:
        How to define a class which consumes generic data type

    Eg-2:
        How to write a generic method which takes argument of any data type
 */


public class GenericMethods {

    /** Generic method type declaration */
    public <E> void printArray( E[] inputArray ) {
        // Display array elements
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }


    /** Generic class declaration */
    class Node<E> {
        E data;
        Node<E> next;
    }


    public static void main( String args[] ) {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        GenericMethods genericMethods = new GenericMethods();

        System.out.println( "Array integerArray contains:" );
        genericMethods.printArray( intArray  ); // pass an Integer array

        System.out.println( "\nArray doubleArray contains:" );
        genericMethods.printArray( doubleArray ); // pass a Double array

        System.out.println( "\nArray characterArray contains:" );
        genericMethods.printArray( charArray ); // pass a Character array
    }
}
