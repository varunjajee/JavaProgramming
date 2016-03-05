package com.muks.DSC.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class MTrieNode {
    char data;
    HashMap<Character, MTrieNode> children = new HashMap<>();
    List<Integer> wordIndexes = new ArrayList<>();
    boolean isLeaf;

    public MTrieNode() {
    }

    public MTrieNode(char data) {
        this.data = data;
    }

    public String toString() {
        return "{" + data + "}";
    }

//    public List<MTrieNode> getChildren() {
//        return children.get(data);
//    }

}
