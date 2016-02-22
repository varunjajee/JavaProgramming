package com.muks.DSC.SuffixTrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mukthar.ahmed on 2/18/16.
 */
public class SuffixNode {
    char data;
    HashMap<Character, SuffixNode> children = new HashMap<>();
    List<Integer> wordIndexes = new ArrayList<>();
    boolean isLeaf;

    public SuffixNode() {
    }

    public SuffixNode(char data) {
        this.data = data;
    }

    public String toString() {
        return "{" + data + "}";
    }
}
