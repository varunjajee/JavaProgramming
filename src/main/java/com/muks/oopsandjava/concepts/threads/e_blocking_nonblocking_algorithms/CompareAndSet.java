package com.muks.oopsandjava.concepts.threads.e_blocking_nonblocking_algorithms;

/**
 * Created by mukthar.ahmed on 4/4/16.
 *
 * In computer science, compare-and-swap (CAS) is an atomic instruction used in multithreading to achieve
 * synchronization. It compares the contents of a memory location to a given value and, only if they are the same,
 * modifies the contents of that memory location to a given new value. This is done as a single atomic operation. The
 * atomicity guarantees that the new value is calculated based on up-to-date information; if the value had been
 * updated by another thread in the meantime, the write would fail. The result of the operation must indicate whether
 * it performed the substitution; this can be done either with a simple boolean response (this variant is often
 * called compare-and-set), or by returning the value read from the memory location (not the value written to it).
 *
 *
 *
 *  Terminologies:-
 *  ---------------
 *  dead lock   = first thread waiting on second and second waiting on the first
 *  priority inversion  = where a high-priority thread is made to waiting to obtain a lock (synchronization)
 *  race condition  = where 2 or more threads are trying to update a shared object and the results are random
 *
 */

public class CompareAndSet {
}
