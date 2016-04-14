package com.muks.DSC.HashMap;

/**
 * Created by mukthar.ahmed on 4/14/16.
 * <p>
 * - HashMap implementation, using chaining type of collision resolution
 */
public class HashMapByChianing {

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
            int index = hashCompute((Integer) key);

            if (table[index].getKey() == key) {
                return table[index].getValue();
            }
            else {
                HashEntry runner = table[index].next;
                while (runner != null) {
                    if (runner.getKey() == key) {
                        return (E) runner.getValue();
                    }
                    else {
                        runner = runner.next;
                    }
                }

                return null;
            }

        }


        public E getNonBlocking(E key) {
            int hash = hashCompute((Integer) key);     // throws null pointer exception if key is null

            // Try first without locking...
            HashEntry[] tab = table;
            //int index = hash & (tab.length - 1);
            HashEntry first = tab[hash];
            HashEntry e;

            for (e = first; e != null; e = e.next) {
                if (e.hash == hash && (key == e.getKey())) {
                    Object value = e.value;
                    // null values means that the element has been removed
                    if (value != null)
                        return (E) value;
                    else
                        break;
                }
            }

            // Recheck under synch if key apparently not there or interference

            synchronized(this) {
                tab = table;
                hash = hash & (tab.length - 1);
                HashEntry newFirst = tab[hash];
                if (e != null || first != newFirst) {
                    for (e = newFirst; e != null; e = e.next) {
                        if (e.hash == hash && (key == e.getKey()))
                            return (E) e.value;
                    }
                }
                return null;
            }
        }


        public int hashCompute(int h) {
//            h ^= (h >>> 20) ^ (h >>> 12);
//            int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
            //return hashCode % SIZE_OF_TABLE;
            return h % SIZE_OF_TABLE;
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
        HashMapByChianing.HashMap<Integer> hashMap = new HashMapByChianing().new HashMap();

        hashMap.put(10, 20);
        hashMap.put(20, 11);
        hashMap.put(21, 1);
        hashMap.put(20, 10);

        int value = hashMap.get(20);
        System.out.println("# Val = " + value);

    }

}
