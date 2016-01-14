package com.muks.DSC.Tries;

/*
 * Created by mukthar.ahmed on 1/13/16.
 */

public class TestingTrie {
    public static void main(String[] args) {

        String[] inputWords = {"muktharahmed", "mukthar", "muks", "tea", "ted", "to"};
        Trie myTrie = new Trie();
        for (String str : inputWords) {
            myTrie.insert(str);
        }

        System.out.println("+ Found = " + myTrie.search("muktharahmed"));

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

        //myTrie.startsWith("mu");

        //System.out.println("+ All getAllWords = " + myTrie.getAllWords(myTrie.root, "mu"));
        System.out.println(myTrie.prefixMatch(myTrie.root, "mu"));



    }

}
