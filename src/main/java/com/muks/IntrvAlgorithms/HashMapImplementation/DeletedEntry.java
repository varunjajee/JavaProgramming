package com.muks.IntrvAlgorithms.HashMapImplementation;

/**
 * Created by mukthar.ahmed on 3/18/16.
 */

public class DeletedEntry extends HashEntry {

    private static DeletedEntry entry = null;

    private DeletedEntry() {
        super(-1, -1);
    }


    public static DeletedEntry getUniqueDeletedEntry() {
        if (entry == null) {
            entry = new DeletedEntry();
        }

        return entry;
    }
}
