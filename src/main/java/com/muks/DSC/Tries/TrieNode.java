package com.muks.DSC.Tries;

import java.util.HashMap;

/*
 * Created by mukthar.ahmed on 1/10/16.
 */
public class TrieNode {
    char data;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char data) {
        this.data = data;
    }

    public String toString() {
        return "{" + data + "}";
    }

}
