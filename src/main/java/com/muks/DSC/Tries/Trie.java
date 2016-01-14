package com.muks.DSC.Tries;

/*  Created by mukthar.ahmed on 1/13/16. */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    /* ===========================================================================================
        Insert a char in to trie creating a node.

        Logic:
            - Iterate over each char of a given input string.
            - for each char found, check if a node is already created from root, if not create one
            - If already char node found, create next char as a child node of curr node
     */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }


    /* ===========================================================================================
       Search for a word and return true if found.

       Logic:
        - Iterate through the entire string, char-by-char
        - If char found and isLeaf = true then its a word found else not.
    */
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        System.out.println("+ Search returned trie node = " + t.children);
        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }


    /* ===========================================================================================
        Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode foundNode = searchNode(prefix);
        if ( foundNode == null)
            return false;
        else
            System.out.println(foundNode.toString());
        return true;
    }


    /* ===========================================================================================
       Search for word, traverse till the last char and return (for others to check if leaf)
     */
    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }


    /* =======================================================================================
       Find all words in a trie
     */
    public Set<String> getAllWords(TrieNode node, String prefix) {
        Set<String> result=new HashSet<>();

        if (node.children.keySet().isEmpty()) {
            System.out.println(" - " + prefix);
            result.add(prefix);

        }
        else {
            for (char ch : node.children.keySet()) {
                prefix += ch;
                System.out.println("+ Before = " + prefix);
                result.addAll(getAllWords(node.children.get(ch), prefix));
                prefix = "";
            }
        }

        return result;
    }


    /* =======================================================================================
       Return all words matching a prefix string.
    */
    public Set<String> prefixMatch(TrieNode node, String prefix) {
        Set<String> result=new HashSet<>();

        if (node.children.keySet().isEmpty()) {
            result.add(prefix);
        }
        else {
            for (int i = 0; i < prefix.length(); i++) {
                HashMap<Character, TrieNode> children = node.children;

                char ch = prefix.charAt(i);
                if (children.containsKey(ch)) {
                    node = children.get(ch);
                }
            }

            // till here, we would have reached last char of input prefix
            return wordsFromPrefix(node, prefix);
        }

        return result;
    }   // end ()


    /*  ========================================================================================

     */
    public Set<String> wordsFromPrefix(TrieNode node, String prefix) {
        Set<String> result=new HashSet<>();

        if (node.isLeaf) {
            result.add(prefix);
            return result;
        }
        else {
            for (char ch : node.children.keySet()) {
                prefix += ch;

                result.addAll(wordsFromPrefix(node.children.get(ch), prefix));
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }

        return result;

    }   // ()


}   // end class
