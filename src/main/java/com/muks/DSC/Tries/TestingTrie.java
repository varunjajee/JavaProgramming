package com.muks.DSC.Tries;

/*
 * Created by mukthar.ahmed on 1/13/16.
 */

public class TestingTrie {
    public static void main(String[] args) {

        String[] inputWords = {"mukthar", "muks", "tea", "ted"};

        Trie myTrie = new Trie();
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



    }

}
