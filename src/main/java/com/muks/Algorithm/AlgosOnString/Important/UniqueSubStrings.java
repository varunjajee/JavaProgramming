package com.muks.Algorithm.AlgosOnString.Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/4/16.
 *
 *  Get all unique sub strings.
 *      - Can be done by either below code or using trie
 *
 *      Trie based logic:
 *          - Insert all unique sub strings into the trie.
 *          - Count the total number of nodes = uniq sub strings
 */
public class UniqueSubStrings {
    public static void main(String[] args) {
        getAllUniqueSubStrings("banana");
    }

    private static List<String> getAllUniqueSubStrings(String str) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j <= str.length() - i; j++) {

                String substr = str.substring(i, i + j);

                if (!list.contains(substr)) {
                    list.add(substr);
                }
            }
        }

        System.out.println("Unique sub strings = " + list.size());

        return list;
    }
}
