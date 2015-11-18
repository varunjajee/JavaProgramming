package com.muks.headfirstjava.immutable;

/*Immutable simply means unmodifiable or unchangeable
String is designed to be immutable for the sake of efficiency and security. This is also the reason why immutable classes are preferred in general
Strings are thread safe as every new string variable gets a new memory in string pool.
If the String is referring to same string value, then a reference is picked as below

 * Created by mukthar.ahmed on 11/17/15.
 */
public class StringImmutable {
    public static void main(String[] args) {
        // Here, its just concatinated and printed.
        String str1="Sachin";
        str1.concat(" Tendulkar");  //concat() method appends the string at the end
        System.out.println(str1);   //will print Sachin because strings are immutable objects


        // whereas, here it is concatinated and assigned to another string
        String str2 = "Sachin";
        str2 = str2.concat(" Tendulkar");
        System.out.println(str2);
    }
}