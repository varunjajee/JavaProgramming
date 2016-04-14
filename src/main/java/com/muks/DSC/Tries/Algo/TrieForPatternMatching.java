package com.muks.DSC.Tries.Algo;

import java.util.ArrayList;

public class TrieForPatternMatching {

    // we are only dealing with keys with chars 'a' to 'z'
    final static int ALPHABET_SIZE = 26;
    final static int NON_VALUE = -1;

    class TrieNode {

        ArrayList<Integer> endingIndices;
        TrieNode[] children;

        TrieNode(boolean isLeafNode, int value) {
            children = new TrieNode[ALPHABET_SIZE];
            this.endingIndices = new ArrayList();
        }

    }

    TrieNode root;

    TrieForPatternMatching() {
        this.root = new TrieNode(false, NON_VALUE);
    }

    private int getIndex(char ch) {
        return ch - 'a';
    }

    public void insert(String key, int offset) {
        // null keys are not allowed
        if (key == null) {
            return;
        }

        key = key.toLowerCase();

        TrieNode currentNode = this.root;
        int charIndex = 0;

        while (charIndex < key.length()) {

            System.out.print("\n Char = " + key.charAt(charIndex));
            int childIndex = getIndex(key.charAt(charIndex));

            if (childIndex < 0 || childIndex >= ALPHABET_SIZE) {
                System.out.println("Invalid Key");
                return;
            }

            if (currentNode.children[childIndex] == null) {
                currentNode.children[childIndex] = new TrieNode(false, NON_VALUE);
            }

            currentNode = currentNode.children[childIndex];

            // add index for this alphabet where it ends in the string
            int in = charIndex + offset;
            System.out.println("C-Index = " + charIndex +
                ", Offset = " + offset + "Curr = " + key.charAt(charIndex) + ", E-Index = " + in);

            currentNode.endingIndices.add(charIndex + offset);

            charIndex += 1;
        }

    }


    private void matchAndPrintPattern(String str) {
        if (str == null) {
            return;
        }

        TrieNode currentNode = root;
        int charIndex = 0;

        while ((charIndex < str.length())) {
            if (currentNode == null) {
                break;
            }

            currentNode = currentNode.children[getIndex(str.charAt(charIndex))];

            charIndex += 1;
        }

//        if (charIndex < str.length()) {
//            System.out.println("Pattern does not exist.");
//        } else {
//            System.out.println("Pattern found in text starting at following indices..");
//            for (int i = 0; i < currentNode.endingIndices.size(); i++) {
//                System.out.print(currentNode.endingIndices.get(i) - (str.length() - 1));
//                System.out.print(",");
//            }
//        }
        return;
    }


    private void printer(String str, int offset) {
        int charIndex = 0;
        System.out.println("");
        for (int i = 0; i < str.length(); i++) {
            int childIndex = getIndex(str.charAt(charIndex));

            int endIndex = charIndex + offset;
            System.out.println("+ Char = " + str.charAt(i) + ", End Index = " + endIndex);
            charIndex += 1;
        }

    }


    private void generateAndInsertSuffixes(String text) {
        for (int i = 0; i < text.length(); i++) {
            this.insert(text.substring(i), i);
        }
    }

    public void printPatternMatches(String text, String pattern) {
        generateAndInsertSuffixes(text);
        matchAndPrintPattern(pattern);
    }

    public static void main(String[] args) {
        TrieForPatternMatching tr = new TrieForPatternMatching();

        String text = "banana";
        String pattern = "ana";

        tr.printPatternMatches(text, pattern);
    }
}