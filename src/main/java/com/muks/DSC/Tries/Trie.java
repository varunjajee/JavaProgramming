package com.muks.DSC.Tries;

/*  Created by mukthar.ahmed on 1/13/16. */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    // Inserts a word into the trie.
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


    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        System.out.println("+ Search returned trie node = " + t.children);
        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

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








    public TrieNode Words(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                break;
            }
        }

        while (!t.isLeaf) {
            //t = children.get(c);
            children = t.children;
        }

        System.out.println(t.toString());
        return t;
    }





    // The main method that finds out the longest string 'input'
    public String getMatchingPrefix(String input)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string

        // Initialize reference to traverse through Trie
        TrieNode crawl = root;

        // Iterate through all characters of input string 'str' and traverse
        // down the Trie
        int level, prevMatch = 0;
        for( level = 0 ; level < length; level++ ) {

            // Find current character of str
            char ch = input.charAt(level);

            // HashMap of current Trie node to traverse down
            HashMap<Character, TrieNode> child = crawl.children;
            System.out.println(
                    "+ children of - " + crawl.toString()+ " = " + child.toString() + ",ch = " +
                            ch);

            // See if there is a Trie edge for the current character
            if ( child.containsKey(ch) ) {
                System.out.println("+ am in..");
                result += ch;          //Update result
                crawl = child.get(ch); //Update crawl to move down in Trie

                System.out.println(" - crawl now() = " + crawl.toString());


                // If this is end of a word, then update prevMatch
                if ( crawl.isLeaf ) {
                    prevMatch = level + 1;
                    System.out.println("+ found word = " + result);
                }
            }
            else {
                break;
            }
        }


        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if( !crawl.isLeaf ) {
            System.out.println("+ Node = " + crawl.toString());
            System.out.println("+ Childs = " + crawl.children);

            HashMap<Character, TrieNode> childs = null;
            Set<Character> key = childs.keySet();

//            for (char k : key) {
//                while (!childs.get(k).isLeaf) {
//                    crawl = childs.get(k);
//                    childs = crawl.children;
//                }
//            }

            return result.substring(0, prevMatch);
        }
        else {
            return result;
        }
    }


    String getChilds(TrieNode node, String word) {
        if (node == null) {
            return "";
        }

        if (node.isLeaf) {
            System.out.println("= f---");
            System.out.println(word);
            return (String.valueOf(node.data));

        }
        else {
            System.out.println("+ Node = " + node.toString());
            System.out.println("+ building = " + word);


            HashMap<Character, TrieNode> keys = node.children;
            System.out.println("keyset = " + keys);
            for (Character c : keys.keySet()) {
                System.out.println("======= node = " + keys.get(c));

                word += getChilds(keys.get(c), word);

            }
            System.out.println("+ word = " + word);
        }

        System.out.println("=- " + word);
        return word;

    }



}
