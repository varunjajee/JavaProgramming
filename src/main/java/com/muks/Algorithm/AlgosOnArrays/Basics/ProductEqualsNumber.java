package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mukthar.ahmed on 5/12/16.
 */
public class ProductEqualsNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        findPairProducts(arr, 6);

        System.out.println(9 % 2);
        System.out.println(9 / 2);
    }

    private static void findPairProducts(int[] arr, int prodValue) {
        Set<Integer> mySet = new HashSet<>();
        int pairElement = 0;

        for (int i = 0; i < arr.length; i++) {
            if (prodValue % arr[i] == 0) {
                mySet.add(arr[i]);
            }
        }

        for (Integer element : mySet) {
            pairElement = prodValue / element;

            if (mySet.contains(pairElement)) {
                System.out.println(element + "," + pairElement);
            }
        }

        System.out.println(mySet.toString());

    }
}
