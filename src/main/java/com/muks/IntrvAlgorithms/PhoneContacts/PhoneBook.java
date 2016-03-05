package com.muks.IntrvAlgorithms.PhoneContacts;

import java.util.HashMap;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class PhoneBook {

    public static void main(String[] args) {
        TriePhoneBook phoneBook = new TriePhoneBook();

        putPhoneBookContacts(phoneBook);

        searchContact(phoneBook, "mukthar");

    }


    private static void putPhoneBookContacts(TriePhoneBook phoneBook) {
        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("name", "Mukthar");
        contact1.put("phone1", "9886653306");
        contact1.put("email", "mukthar.am@gmail.com");
        contact1.put("phone2", "blah-blah");

        phoneBook.insert(contact1);
    }

    private static void searchContact(TriePhoneBook phoneBook, String name) {
        phoneBook.searchContact(name);
    }
}
