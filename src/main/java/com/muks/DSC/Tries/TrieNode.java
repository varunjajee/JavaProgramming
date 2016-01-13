package com.muks.DSC.Tries;

import java.util.HashMap;

/*
 * Created by mukthar.ahmed on 1/10/16.
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }

    public String toString() {
        return "{" + c + "}";
    }

}
