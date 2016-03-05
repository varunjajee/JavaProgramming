package com.muks.IntrvAlgorithms.PhoneContacts;

import java.util.HashMap;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class TrieNode {
    char data;

    HashMap<Character, TrieNode> children = new HashMap<>();

    boolean isLeaf;

    HashMap<String, String> contact = new HashMap<>();

    public TrieNode() {}

    public TrieNode(char ch) {
        this.data = ch;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return this.children;
    }

    public HashMap<String, String> getContact() {
        return contact;
    }

    public String toString() {
        return "[" + data + "]";
    }
}
