package com.muks.DSC.Tries;

import java.util.HashMap;

/**
 * Created by mukthar.ahmed on 3/6/16.
 */
public class TriePatternMatch {

    TrieNode root = new TrieNode();

    public void insert (String str, int offset) {
        HashMap<Character, TrieNode> children = root.children;

        int charIndex = 0;  /** very important to track the index of the char from the parent string */

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            TrieNode t = null;
            if ( children.containsKey(ch) ) {
                t = children.get(ch);
            }
            else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }

            int endIndex = charIndex + offset;

            System.out.println("+ char = " + ch + ", ending index = " + endIndex);

            t.endingIndices.add(endIndex);

            charIndex++;
            children = t.children;
        }

    }

    private void trieGenerator(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(" i = " + i + ", " + str.substring(i));
            /** inserting sub-strings and offset
             * Eg: banana is inserted as banana, anana, nana, ana, na, a */
            insert(str.substring(i), i);
        }
    }


    private void patternMatcher(String str) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode currNode = root;
        int charIndex = 0;

        while (charIndex < str.length()) {
            if (currNode == null) {
                break;
            }

            currNode = currNode.children.get(str.charAt(charIndex));
            charIndex += 1;
        }

        if (charIndex < str.length()) {
            System.out.println("Pattern does not exist.");

        } else {
            System.out.println("Pattern found in text starting at following indices..");
            System.out.println("+ Current Node: " + currNode.toString() + ", Indices: " +
            currNode.endingIndices.toString());

            for (int i = 0; i < currNode.endingIndices.size(); i++) {
                System.out.print(currNode.endingIndices.get(i) - (str.length() - 1));
                System.out.print(",");
            }
        }

    }

    public static void main(String[] args) {
        String mainString = "banana";
        String mainString2 = "abcbcglx";

        String subString = "ana";
        String subString2 = "bcgl";

        TriePatternMatch patternTrie = new TriePatternMatch();
        patternTrie.trieGenerator(mainString);
        patternTrie.trieGenerator(mainString2);

        //patternTrie.patternMatcher(subString);
        patternTrie.patternMatcher(subString2);
    }
}
