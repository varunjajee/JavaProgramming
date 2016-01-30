package com.muks.DSC.Tries;

/*
 * Created by mukthar.ahmed on 1/13/16.
 */

import java.util.Arrays;


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

//        String[] inputWords = {"mukthar", "muks", "tea", "ted"};
//        String[] anagramic = {"cat", "tac", "act", "dog", "god"};
//
//        Trie myTrie = new Trie();

        /*
        myTrie.insert("tea");
        myTrie.insert("to");

        myTrie.insert("ted");
        myTrie.insert("muktharahmed");
        myTrie.insert("mukthar");
        myTrie.insert("muksie");



//        System.out.println("+ search with prefix = " + myTrie.startsWith("mu"));
//        System.out.println("+ search with prefix = " + myTrie.search("muks"));

        //System.out.println("+ All getAllWords = " + myTrie.getAllWords(myTrie.root, ""));
        System.out.println(myTrie.prefixMatch(myTrie.root, "mu"));
        */



        /* //Eg: (2)
        List<Integer> index = new ArrayList<>();
        index.add(1);
        index.add(2);
        System.out.println("+ index = " + index.toString());


        for (int i = 0; i < anagramic.length; i++) {
            //System.out.println("+ Word = " +  anagramic[i] + ", Index = " + i);
            System.out.println("");
            myTrie.insert(sortString(anagramic[i]), i);
        }


        String sWord = "cat";
        List<Integer> anagrams = myTrie.searchIndexes(sortString(sWord));
        System.out.println("+ Anagrams for + " + sWord + " are: ");

        for (int i = 0; i < anagrams.size(); i++) {
            System.out.println(anagramic[anagrams.get(i)]);
        }
        */



        /*
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

    public static String sortString(String inString) {
        char[] ar = inString.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }

}
