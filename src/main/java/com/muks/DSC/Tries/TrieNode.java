package com.muks.DSC.Tries;

import java.util.Collection;
import java.util.LinkedList;

/*
 * Created by mukthar.ahmed on 1/10/16.
 */
public class TrieNode {


    char content;
    public boolean marker;
    public Collection<TrieNode> child;

    public TrieNode(char c) {
        child = new LinkedList<TrieNode>();
        marker = false;
        content = c;
    }

    public TrieNode subNode(char c){
        if (child != null) {
            for (TrieNode eachChild : child) {
                if (eachChild.content == c) {
                    return eachChild;
                }
            }
        }
        return null;
    }

    public void prinTrieNode() {
        System.out.println("{" + content + "}");
    }

}
