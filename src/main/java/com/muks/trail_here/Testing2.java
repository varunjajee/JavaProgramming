package com.muks.trail_here;

/**
 * Created by mukthar.ahmed on 11/25/15.
 */
public class Testing2 {
    public static void main(String[] args) {

        String str1 = "mukthar";
        String str2 = "mukthar";

        System.out.println(str2);

        System.out.println("1 - " + Integer.toHexString(System.identityHashCode(str1)));
        System.out.println("2 - " + Integer.toHexString(System.identityHashCode(str2)));
    }
}
