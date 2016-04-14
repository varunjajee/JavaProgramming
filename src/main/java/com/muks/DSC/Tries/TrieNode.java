package com.muks.DSC.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TrieNode - Created by mukthar.ahmed on 1/10/16.
 */
public class TrieNode {
    char data;
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public List<Integer> wordIndexes = new ArrayList<>();
    boolean isLeaf;

    boolean isVisited = false;

    public List<Integer> endingIndices = new ArrayList<>();   /** user for pattern matching */

    public TrieNode() {
    }

    public TrieNode(char data) {
        this.data = data;
    }

    public String toString() {
        return "[" + data + "]";
    }

}
