package com.muks.DSC.Tries;

/*
 * Created by mukthar.ahmed on 1/13/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*  =====   Tricky FAQ  =====

    Q - Given a dictionary of millions of words, find all the anagrams of a word
        Solution:
            - Iterating all the words from dictionary;
                - Sort the words and insert it to a trie
                - insertion logic, when a word ends, insert the index of the word at the leaf node.
                - Fyi, maintain a leaf nodes with List<Integer> holding index num of inserted word.


            - Search logic:
                - While searching for a word, char-by-char;
                    -- If the node is leaf, then return the index List<Index>



    Q - Given a dictionary, find all the palindromes of a given word.
        Solution:
            - Same as the above but store final word non-sorted instead of index.

 */

public class TestingTrie {
    public static void main(String[] args) {

        //anagramsFromDictionary();

        //findCountineousWord();

        prefixSearch();

    }   // end main()


    private static void prefixSearch() {
        //String[] inputWords = {"mukthar", "muks", "tea", "ted", "mukthar ahmed", "muksie"};
        String[] inputWords = {"mu", "muksie", "trie"};

        Trie myTrie = new Trie();

        for (String inWord : inputWords) {
            myTrie.insert(inWord);
        }

        /** Print all words in a trie */
//        List<String> list = new ArrayList<>();
//        list = myTrie.getWords();
//        System.out.println("\n+ Printing all words - " + list.toString());

//        System.out.println("+ search with prefix = " + myTrie.search("muks"));
        //System.out.println("+ All getWordsByPrefix = " + myTrie.wordsFromPrefix(myTrie.root, "m"));

        /** Get words from prefix match */
        System.out.println(myTrie.prefixMatch(myTrie.root, "m"));
    }


    // ====================================================================================
    private static void findCountineousWord() {
        /**
         Consider the following dictionary
         { i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango}

         Input:  ilike
         Output: Yes
         The string can be segmented as "i like".

         Input:  ilikesamsung
         Output: Yes
         The string can be segmented as "i like samsung" or "i like sam sung".

         */
        String[] inputWords = {"i", "like", "sam", "sung"};
        Trie myTrie = new Trie();
        String contineousWord = "";

        for (int i = 0; i < inputWords.length; i++) {
            contineousWord = contineousWord + inputWords[i];
            myTrie.insert(contineousWord);
        }

        System.out.println("+ search with prefix = " + myTrie.search("ilike"));
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
