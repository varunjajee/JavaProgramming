package com.muks.oopsandjava.concepts.immutable;

/*  Immutable simply means unmodifiable or unchangeable
    - String is designed to be immutable for the sake of efficiency and security.
    - This is also the reason why immutable classes are preferred in javageneraleg

    - Strings are thread safe "as every new string variable gets a new memory in string pool
    unless their values are same".

    - If the String is referring to same string value, then a reference is picked as below


 * Created by mukthar.ahmed on 11/17/15.
 */
public class StringImmutable {
    public static void main(String[] args) {
        // Eg # 1 (String concatinated and printed/accessed:
        String str1="Sachin";
        str1.concat(" Tendulkar");  //concat() method appends the string at the end
        System.out.println(str1);   //will print Sachin because strings are immutable objects


        // whereas, here it is concatinated and assigned to another string
        String str2 = "Sachin";
        str2 = str2.concat(" Tendulkar");
        System.out.println(str2);

        /*
         If 2 strings hold same value, jvm doesn't create a new string rather assigns a ref to
         the second string object
          */

        // Eg # 2 (if 2 string are of same value, ref is picked from string pool):
        String firstName = "mukthar";
        String secondName = "mukthar";
        String thirdName = "Ahmed";


        System.out.println("First Name: " + firstName
                + ", Refence Location: " + Integer.toHexString(System.identityHashCode(firstName)));

        System.out.println("Second Name: " + secondName
                + ", Refence Location: " + Integer.toHexString(System.identityHashCode
                (secondName)));

        System.out.println("Third Name: " + thirdName
                + ", Refence Location: " + Integer.toHexString(System.identityHashCode(thirdName)));


        // Eg # 3: (Chars vary in their cases):
        String fourthName = "Mukthar"; // first char is in upper case

        System.out.println("First Name: " + firstName
                + ", Refence Location: " + Integer.toHexString(System.identityHashCode(firstName)));

        System.out.println("Second Name: " + secondName
                + ", Refence Location: " + Integer.toHexString(System.identityHashCode
                (fourthName)));
    }


}