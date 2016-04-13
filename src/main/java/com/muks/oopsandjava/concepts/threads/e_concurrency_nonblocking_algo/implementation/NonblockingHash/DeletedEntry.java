package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation.NonblockingHash;

/**
 * Created by mukthar.ahmed on 4/13/16.
 */
public class DeletedEntry extends HashEntry {

    private static DeletedEntry entry = null;
    public DeletedEntry() {
        super(-1, -1);
    }

    public static DeletedEntry getUniqDeletedEntry() {
        if (entry == null) {
            return new DeletedEntry();
        }
        else {
            return entry;
        }
    }

}
