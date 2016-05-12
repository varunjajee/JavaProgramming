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
    }

    private static void findPairProducts(int[] array, int value) {
        Set<Integer> hashSet = new HashSet<>();
        int pairElement = 0;
        for (int element : array) {
            if (value % element == 0) {
                hashSet.add(element);
            }
        }

        for (Integer element : hashSet) {
            pairElement = value / element;

            if (hashSet.contains(pairElement)) {
                System.out.println(element + "," + pairElement);
            }
        }

    }
}
