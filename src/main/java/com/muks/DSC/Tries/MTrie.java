package com.muks.DSC.Tries;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class MTrie {
    MTrieNode root = new MTrieNode();


    public void insert(String word) {
        HashMap<Character, MTrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (children.containsKey(ch)) {
                System.out.println(children.toString());
            }
            else {
                children.put(ch, new MTrieNode(ch));
            }

        }
    }
}
