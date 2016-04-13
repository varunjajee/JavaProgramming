package com.muks.IntrvAlgorithms.HashMapImplementation;

/**
 * Created by mukthar.ahmed on 3/18/16.
 *
 *  Link - http://www.algolist.net/Data_structures/Hash_table/Open_addressing
 *
 *  This - Open addressing (below code logic)
 *      - Open addressing makes use of liner probing.
 *
 *      - Drawbacks:
 *          - When hash increases in its no. of deletion operations, it clogs with deleted values and badly hampers
 *          performance.
 *
 *      - Collision resolution: (Open adresing)
 *          - key % HASH_SIZE, if that is occupied too, then find the next available slot and write to it.
 *          - To assist collision resolution, we make use of DeletedEntry object and write the object while deleting.
 *
 *          - DeletedEntry object will be used to write an key-val if no other empty slot is found.
 *
 *      - Collision resolution: (Chaining)
 *          - Chaining makes use of the Singly Linked List.
 *          - Each hash slot has is chained to a singly linked list, which is used when collision happens to the same
 *          slot. Algo resolves it by writing it to the next available node of the Singly linkedlist.
 */

public class HashMapCustom {

    private static final int TABLE_SIZE = 128;

    HashEntry[] table;

    public HashMapCustom() {
        this.table = new HashEntry[TABLE_SIZE];     /** Set the HashMap capacity */

        for (int i = 0; i < TABLE_SIZE; i++) {      /** Init HashMap with null */
            this.table[i] = null;
        }
    }

    public void putModified(int key, int val) {
        int hash = (key % TABLE_SIZE);

        int initialHash = -1;

        int indexOfDeletedEntry = -1;

        while ( initialHash != hash &&
            (table[hash] != null || table[hash] != DeletedEntry.getUniqueDeletedEntry() )
            && table[hash].getKey() != key) {

            System.out.println("# hash = " + hash + ", " + table[hash] );

            hash = (hash+1) % TABLE_SIZE;

        }

        System.out.println("# Found uniq = " + hash);

    }


    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);
        System.out.println("\n===========");
        System.out.println("+ Key = " + key + ", is hashed to HashValue = " + hash);


        int initialHash = -1;

        int indexOfDeletedEntry = -1;

        /** handling hash collision */
        while (hash != initialHash
            && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null)
            && table[hash].getKey() != key ) {

            System.out.println("# hash =" + hash
            + ", initHash = " + initialHash + ", tab[hash] = " + table[hash].getKey()
            + ", tag[hash].getKey() = " + table[hash].getKey());
            System.out.println("\n Hash Collision - FOUND...\n");

            if (initialHash == -1) {
                initialHash = hash;
            }

            if (table[hash] == DeletedEntry.getUniqueDeletedEntry()) {
                System.out.println("# Deleted: "
                + DeletedEntry.getUniqueDeletedEntry().getKey());
                indexOfDeletedEntry = hash;
            }

            hash = (hash + 1) % TABLE_SIZE;
        }

        System.out.println("+ HashValue=" + hash);

        /** Initial hash entry */
        if ((table[hash] == null || hash == initialHash) && indexOfDeletedEntry != -1) {
            System.out.println("# Inserting @ deleted entry...");
            table[indexOfDeletedEntry] = new HashEntry(key, value);

        } else if (initialHash != hash) {   /** Over ride the key's value */
            if (table[hash] != DeletedEntry.getUniqueDeletedEntry()
                && table[hash] != null
                && table[hash].getKey() == key) {

                System.out.println("# Updating the value,...");
                table[hash].setValue(value);

            }
            else {    /** new slot entry */
                System.out.println("# Inserting at a new hashed value");
                table[hash] = new HashEntry(key, value);
            }
        }
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        int initialHash = -1;

        while (hash != initialHash
            && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
            && table[hash].getKey() != key) ) {

            if (initialHash == -1) {
                initialHash = hash;
            }

            hash = (hash + 1) % TABLE_SIZE;

        }

        if (table[hash] == null || hash == initialHash) {
            return -1;
        }
        else {
            System.out.println("# Was hashed @ " + hash);
            return table[hash].getValue();
        }

    }

    

    public void remove(int key) {
        int hash = (key % TABLE_SIZE);
        int initialHash = -1;

        while (hash != initialHash
            && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
            && table[hash].getKey() != key) ) {

            if (initialHash == -1) {
                initialHash = hash;
            }

            hash = (hash + 1) % TABLE_SIZE;

        }

        if (hash != initialHash && table[hash] != null) {
            table[hash] = DeletedEntry.getUniqueDeletedEntry();
        }

    }
}
