package com.muks.DSC.Tries;

/*
 * Created by mukthar.ahmed on 1/13/16.
 */

public class TestingTrie {
    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.insert("tea");
        myTrie.insert("to");
        myTrie.insert("ted");

        System.out.println("+ Found = " + myTrie.search("t"));
    }

}
