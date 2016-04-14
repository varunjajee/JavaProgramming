package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation;

/**
 * Created by mukthar.ahmed on 4/14/16.
 * <p>
 * - HashMap implementation, using chaining type of collision resolution
 */
public class ConcurrentHashMap {

    class HashMap<E> {
        int SIZE_OF_TABLE = 128;
        HashEntry<E>[] table;

        HashMap() {
            table = new HashEntry[SIZE_OF_TABLE];
            for (int i = 0; i < SIZE_OF_TABLE; i++) {
                table[i] = null;
            }
        }

        public void put(int key, int value) {
            int hash = hashCompute(key);
            System.out.println("# Hashed to = " + hash);

            HashEntry newHashEntry = new HashEntry(key, value);

            if (table[hash] == null) {
                table[hash] = newHashEntry;

            } else {
                HashEntry runner = table[hash];
                while (runner.next != null) {
                    if (runner.key == newHashEntry.key) {
                        runner.value = newHashEntry.value;  /** updating the value of found key */
                        break;

                    } else {
                        runner = runner.next;
                    }
                }

                if (runner.next == null) {
                    if (runner.key == newHashEntry.key) {
                        runner.value = newHashEntry.value;
                    } else {
                        runner.next = newHashEntry;
                    }
                }
            }

        }

        public E get(E key) {
            int hash = hashCompute((Integer) key);


            if (table[hash].getKey() == key) {
                return table[hash].getValue();

            } else {
                HashEntry runner = table[hash].next;

                while (runner != null) {
                    if (runner.hash == hash && runner.getKey() == key) {
                        if ( runner.getValue() != null) {
                            return (E) runner.getValue();
                        }
                        else {
                            break;      /** value is removed by other thread, use synchronized block now */
                        }
                    } else {
                        runner = runner.next;
                    }
                }

                Object lockObj = new Object();
                synchronized (lockObj) {
                    // re-lookup in the list for the key till the previous hash found
                }
            }

            return null;

        }


        public E getNonBlocking(E key) {
            int hash = hashCompute((Integer) key);     // throws null pointer exception if key is null


            // Try first without locking...
            HashEntry[] tab = table;
            int index = hash & (tab.length - 1);
            HashEntry first = tab[index];
            HashEntry e;

            for (e = first; e != null; e = e.next) {
                if (e.hash == hash && (key == e.getKey())) {
                    Object value = e.value;
                    // null values means that the element has been removed
                    if (value != null) {
                        return (E) value;
                    } else {
                        break;
                    }
                }
            }

            // Recheck under synch if key apparently not there or interference
            synchronized (this) {
                tab = table;
                hash = hash & (tab.length - 1);
                HashEntry newFirst = tab[hash];
                if (e != null || first != newFirst) {
                    for (e = newFirst; e != null; e = e.next) {
                        if (e.hash == hash && (key == e.getKey())) {
                            return (E) e.value;
                        }
                    }
                }
                return null;
            }
        }


        public int hashCompute(int key) {
//            key ^= (key >>> 20) ^ (key >>> 12);
//            int hashCode = key ^ (key >>> 7) ^ (key >>> 4);
            //return hashCode % SIZE_OF_TABLE;
            return key % SIZE_OF_TABLE;
        }
    }

    class HashEntry<E> {
        final E key;
        //E value;
        protected volatile E value;
        HashEntry<E> next;
        int hash;

        public HashEntry(E key, E value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public E getKey() {
            return this.key;
        }

        public E getValue() {
            return this.value;
        }
    }


    public static void main(String[] args) {
        HashMap<Integer> hashMap = new ConcurrentHashMap().new HashMap();

        hashMap.put(10, 20);
        hashMap.put(20, 11);
        hashMap.put(21, 1);
        hashMap.put(20, 10);

        int value = hashMap.get(20);
//        int value = hashMap.getNonBlocking(20);
        System.out.println("# Val = " + value);

    }

}
