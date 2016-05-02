package com.muks.DSC.Tries.Algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/2/16.
 *
 * - Get a count of distinct sub strings from a string
 *
 * approach 1: iterative O(n^2)
 *
 * approach 2: using Trie
 *      - Insert all the suffixes into the trie, eg: banana, anana, nana, ana, na, a
 *      - The count will be equal to all the nodes in the trie.
 *
 */

public class DistinctSubStrings {

    public static void main(String[] args) {
        getAllUniqueSubStrings("banana");
    }

    static List<String> getAllUniqueSubStrings(String str) {
        List<String> set = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            for (int j = 0; j <= str.length() - i; j++) {
                String elem = str.substring(i, i +j);

                if (!set.contains(elem)) {
                    set.add(elem);
                }
            }
        }

        System.out.println("Unique sub strings = " + set.size());

        return set;
    }
}
