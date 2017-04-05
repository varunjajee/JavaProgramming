package com.muks.oopsandjava.concepts.b_immutable;

/**  Immutable simply means unmodifiable or unchangeable
 *
 *  Immutability of a string is due to following reasons
 *  1) Operational and memory efficiency.
 *      - String literals are being cached in String pool.
 *
 *      Eg:
 *      If, String name = "mukthar";
 *      and another variable, String secondName = "mukthar";
 *
 *      Then java doesn't create a new variable rather uses the reference of name to secondName, thus saving space
 *      consumption and object retrieval is also easy.
 *
 *      Check: to check if java doesn't or does create a new object for the same string value,
 *      use System.identityHashCode(name) to check the address of the object in memory.
 *
 *
 *  2) Security reasons and concerns
 *      String objects are cached in String pool. Since cached String literals are shared between multiple clients
 *      there is always a risk, where one client's action would affect all other client. For example, if one client
 *      changes the value of String "Test" to "TEST", all other clients will also
 *      see that value as explained in the first example.
 *
 *      Since caching of String objects was important from performance reason this risk was avoided by making String
 *      class Immutable. At the same time, String was made final so that no one can compromise invariant of
 *      String class e.g. Immutability, Caching, hashcode calculation etc by extending and overriding behaviors.
 *      Another reason of why String class is immutable could die due to HashMap.
 *
 *      Since Strings are very popular as HashMap key, it's important for them to be immutable so that they can retrieve
 *      the value object which was stored in HashMap. Since HashMap works in the principle of hashing, which requires
 *      same hash value to function properly. Mutable String would produce two different hashcodes at the time of
 *      insertion and retrieval if contents of String was modified after insertion, potentially losing the value
 *      object in the map.
 *
 *      Read more: http://javarevisited.blogspot.com/2010/10/why-string-is-immutable-or-final-in-java.html#ixzz4dMZ5T5OA

 *
 *
 *  3) Ways to create a String object
 *      - String literal Eg: String name = "mukthar"    - Resides in string pool
 *      - String object Eg: String name = new String("muthar")  - Resides in JVM heap
 *
 *  4) About string literal pool and heap
 *  String Literal Pool is a Collection of references that points to the String Objects.
 *  String s = "Hello"; (Assume there is No object on the Heap named "Hello"), will create an String object "Hello"
 *  on the heap, and will place an reference to this object in the String Literal Pool (Constant Table)
 *
 * Created by mukthar.ahmed on 11/17/15.
 */
public class StringImmutable {
    public static void main(String[] args) {
        // Eg # 1 (String concatinated and printed/accessed:
        String str1 = "Sachin";
        str1.concat(" Tendulkar");  //concat() method appends the string at the end

        System.out.println(str1);   //will print Sachin because strings are b_immutable objects


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