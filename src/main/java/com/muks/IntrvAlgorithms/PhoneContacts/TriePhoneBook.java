package com.muks.IntrvAlgorithms.PhoneContacts;

import java.util.HashMap;

/**
 * - Created by mukthar.ahmed on 3/5/16.
 */
public class TriePhoneBook {
    TrieNode root = new TrieNode();

    public void insert(HashMap<String, String> contactDetails) {
        String str = contactDetails.get("name");
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);


            if ( children.containsKey(ch) ) {
                t = children.get(ch);
            }
            else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }

            children = t.getChildren();
        }

        t.isLeaf = true;    /** setting as leaf node */

        HashMap<String, String> details = t.contact;

        details.put("name", str);
        details.put("phone1", contactDetails.get("phone1") );
        if (contactDetails.containsKey("phone2")) {
            details.put("phone2", contactDetails.get("phone2") );
        }

        details.put("email", contactDetails.get("email"));
    }


    public void searchContact(String name) {
        if ( searchUtil(name) == null ) {
            System.out.println("+ Contact - \"" + name + "\", FOUND");
        }
        else {
            System.out.println("+ Contact - \"" + name + "\", NOT FOUND");
        }
    }


    public HashMap<String, String> searchUtil(String name) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode t = null;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if ( children.containsKey(ch) ) {
                t = children.get(ch);
            }
            else {
                return null;
            }
        }

        return t.getContact();
    }
}
