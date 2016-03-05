package com.muks.DSC.Tries;

/*  Created by mukthar.ahmed on 1/13/16. */

import java.util.*;

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
        HashMap<Character, TrieNode> children = this.root.children;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode t;
            if (children.containsKey(ch)) {
                t = children.get(ch);
            } else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }

            children = t.children;

            //set leaf node
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    public void insert(String word, int indexOfWord) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }

            children = node.children;

            //set leaf node
            if (i == word.length() - 1) {
                System.out.println("+ Char = " + node + ", Index of the word = " + indexOfWord);
                node.isLeaf = true;
                node.wordIndexes.add(indexOfWord);
                System.out.println("+ index = " + node.wordIndexes.toString());
            }
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
        System.out.println("===" + t.toString());
        if (t != null && t.isLeaf) {
            System.out.println("+ This word has indeces = " + t.wordIndexes.toString());
            return true;
        } else {
            return false;
        }
    }


    /* Search for a word and return Index List<Integer> */
    public List<Integer> searchIndexes(String word) {

        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf) {
            System.out.println("+ = " + t.wordIndexes.toString());
            return t.wordIndexes;
        } else {
            return null;
        }
    }

    /* ===========================================================================================
        Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode foundNode = searchNode(prefix);
        if (foundNode == null) {
            return false;
        } else {
            System.out.println(foundNode.toString());
        }
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


    /**
     * =========================================================================================
     * Get all words from a node, if start node is leaf then it will print all words in a trie
     */
    public List<String> getWords() {
        List<String> list = new ArrayList<>();
        for (Character key : root.children.keySet()) {
            System.out.println("\n+ Sending word builder - [" + key + "]");
            doWords(list, root.children.get(key), "");
        }

        return list;
    }

    public List<String> getWords(TrieNode node, String prefix) {
        List<String> list = new ArrayList<>();

        for (Character key : node.children.keySet()) {
            System.out.println("\n+ Sending word builder - [" + key + "] with Prefix = " + prefix);
            doWords(list, node.children.get(key), prefix);
        }

        return list;
    }

    /**
     * Get all words from a node
     */
    private void doWords(List<String> list, TrieNode node, String word) {

        if (node != null) {
            word += node.data;
            System.out.println(word);

            if (node.isLeaf) {
                list.add(word);
            }

            for (Character key : node.children.keySet()) {
                System.out.println(" - Child = [" + key + "],  WORD = " + word);
                doWords(list, node.children.get(key), word);
            }
        }
    }


    /** =======================================================================================
       Return all words matching a prefix string.
    */
    public List<String> prefixMatch(TrieNode node, String prefix) {
        List<String> result = new ArrayList<>();

        if (node.children.keySet().isEmpty()) {
            result.add(prefix);

        } else {
            for (int i = 0; i < prefix.length(); i++) {
                HashMap<Character, TrieNode> children = node.children;

                char ch = prefix.charAt(i);

                if (children.containsKey(ch)) {
                    node = children.get(ch);
                }
            }

            System.out.println("\n+ Full prefix match found, stepping out @ node = " + node);
            System.out.println("children = " + node.children.toString());

            /** Get all words from the last node we found */
            return getWords(node, prefix);
        }

        return result;

    }   // end ()


    
}   // end class
