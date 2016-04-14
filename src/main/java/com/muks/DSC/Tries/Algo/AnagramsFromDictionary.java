package com.muks.DSC.Tries.Algo;

import com.muks.DSC.Tries.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mukthar.ahmed on 4/15/16.
 */
public class AnagramsFromDictionary {

    public static void main(String[] args) {
        anagramsFromDictionary();
    }
    // ====================================================================================
    public static void anagramsFromDictionary() {
        /**
         Given a dictionary, find all anagram words to each other
         */

        String[] anagramic = {"cat", "tac", "act", "dog", "god"};
        List<Integer> index = new ArrayList<>();
        index.add(1);
        index.add(2);
        System.out.println("+ index = " + index.toString());

        Trie myTrie = new Trie();

        for (int i = 0; i < anagramic.length; i++) {
            System.out.println("");
            myTrie.insert(sortString(anagramic[i]), i);
        }


        String sWord = "cat";
        List<Integer> anagrams = myTrie.searchIndexes(sortString(sWord));
        System.out.println("+ Anagrams for + " + sWord + " are: ");

        for (int i = 0; i < anagrams.size(); i++) {
            System.out.println(anagramic[anagrams.get(i)]);
        }
    }

    public static String sortString(String inString) {
        char[] ar = inString.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }

}
