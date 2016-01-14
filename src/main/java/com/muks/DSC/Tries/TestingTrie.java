package com.muks.DSC.Tries;

/*
 * Created by mukthar.ahmed on 1/13/16.
 */

public class TestingTrie {
    public static void main(String[] args) {
        Trie myTrie = new Trie();
//        myTrie.insert("tea");
//        myTrie.insert("to");
//        myTrie.insert("ted");
        myTrie.insert("mukthar");

//        System.out.println("+ Found = " + myTrie.search("mukthar"));
//        System.out.println("+ Starts with = " + myTrie.startsWith("t"));
//        System.out.println("+ Prefix match = " + myTrie.getMatchingPrefix("mu"));
//        String word = "";
//        HashMap<Character, TrieNode> child = myTrie.root.children;
//        //System.out.println("+ "+ child.get("m").toString());
//
//        System.out.println("=== " + child.keySet());
//        for (char k : child.keySet()) {
//            System.out.println("---- " + child.get(k).toString());
//            myTrie.getChilds(child.get(k), word);
//        }
        String word = "";
        myTrie.getChilds(myTrie.root, word);



        System.out.println("+ Words = " + word);


    }

}
