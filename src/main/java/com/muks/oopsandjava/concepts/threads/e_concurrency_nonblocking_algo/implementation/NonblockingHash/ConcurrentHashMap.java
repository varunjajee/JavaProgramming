package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation.NonblockingHash;

/**
 * Created by mukthar.ahmed on 4/13/16.
 * <p>
 * Link:
 * http://www.ibm.com/developerworks/library/j-jtp08223/
 */


public class ConcurrentHashMap {
    private static int SIZE;
    private HashEntry[] table;

    public ConcurrentHashMap(int capacity) {
        this.SIZE = capacity;
        this.table = new HashEntry[SIZE];

        /** init all table to null*/
        for (int i = 0; i < 128; i++) {
            table[i] = null;
        }
    }

    private int hashCompute(int key) {
        //return Math.abs(key.hashCode()) % capacity;
        return key % SIZE;
    }

    public void put(int key, int val) {
        int hash = hashCompute(key);

        int initialHash = -1;
        int deletedEntryHash = -1;

        while (hash != initialHash &&
            table[hash] == DeletedEntry.getUniqDeletedEntry() || table[hash] != null &&
            key != table[hash].getKey()
            ) {

            System.out.println("# Recomputing hash.");
            if (initialHash == -1) {
                initialHash = hash;
            }

            if (table[hash] == DeletedEntry.getUniqDeletedEntry()) {
                deletedEntryHash = hash;
            }

            hash = (hash + 1) % SIZE;
        }

        if ( (table[hash] == null || hash == initialHash) && (deletedEntryHash == -1) ) {
            table[hash] = new HashEntry(key, val);

        }
        //else if (hash)
    }

    public Object get(int key) {
        int hash = hashCompute(key);     // throws null pointer exception if key is null

        // Try first without locking...
        HashEntry[] tab = table;
        int index = hash & (tab.length - 1);
        HashEntry first = tab[index];
        HashEntry e;

        for (e = first; e != null; e = e.next) {
            if (e.hash == hash && (key == e.getKey())) {
                Object value = e.value;
                // null values means that the element has been removed
                if (value != null)
                    return value;
                else
                    break;
            }
        }

        // Recheck under synch if key apparently not there or interference
        synchronized(this) {
            tab = table;
            index = hash & (tab.length - 1);
            HashEntry newFirst = tab[index];
            if (e != null || first != newFirst) {
                for (e = newFirst; e != null; e = e.next) {
                    if (e.hash == hash && (key == e.getKey()))
                        return e.value;
                }
            }
            return null;
        }
    }

    private static int hash(int key) {
        return key % SIZE;
    }
}
