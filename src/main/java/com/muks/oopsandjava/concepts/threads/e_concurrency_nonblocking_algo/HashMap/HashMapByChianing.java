package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.HashMap;

/**
 * Created by mukthar.ahmed on 4/14/16.
 *
 * Link : http://www.algolist.net/Data_structures/Hash_table/Chaining
 * Resizable link: http://javainsimpleway.com/java/upcasting-and-downcasting-in-java/
 */

public class HashMapByChianing {

    class HashMap<E> {
        private final int TABLE_SIZE = 128;
        private float loadFactor = 0.75f;
        private int maxSize = 96;
        private int size = 0;

        HashEntry<E>[] table;

        HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++) {
                table[i] = null;
            }
        }


        private void resize() {
            int tableSize = 2 * table.length;
            maxSize = (int) (tableSize * loadFactor);

            HashEntry[] oldTable = table;
            table = new HashEntry[tableSize];
            size = 0;
            for (int i = 0; i < oldTable.length; i++) {
                if (oldTable[i] != null) {
                    put((Integer) oldTable[i].getKey(), (Integer) oldTable[i].getValue());
                }
            }
        }


        /** Insert
         * */
        public void put(int key, int value) {
            int hash = (key % TABLE_SIZE);

            if (table[hash] == null) {
                table[hash] = new HashEntry(key, value);
                size++;

            } else {
                HashEntry entry = table[hash];

                while (entry.next != null && (Integer) entry.getKey() != key) {
                    entry = entry.next;
                }

                if ( (Integer) entry.getKey() == key) {
                    entry.setValue(value);
                }  else {
                    entry.next = new HashEntry(key, value);
                }
                size++;
            }

            if (size > maxSize) {
                resize();
            }
        }


        /** Retrival
         */
        public int get(int key) {
            int hash = (key % TABLE_SIZE);

            if (table[hash] == null) {
                return -1;
            } else {
                HashEntry entry = table[hash];

                while (entry != null && (Integer) entry.getKey() != key) {
                    entry = entry.next;
                }

                if (entry == null) {
                    return -1;
                } else {
                    size--;
                    return (Integer) entry.getValue();
                }
            }
        }


        /** Delete
         */
        public boolean remove(E key) {
            int hash = hashCompute((Integer) key);

            if (table[hash] == null) {
                return false;
            }
            else {
                HashEntry<E> previous = null;
                HashEntry<E> current = table[hash];

                while (current.next != null && current.getKey() != key) {
                    previous = current;
                    current = current.next;
                }

                if (current.getKey() == key) {
                    if (previous == null) {             /** If node to delete is head */
                        table[hash] = current.next;
                    }
                    else {
                        previous.next = current.next;
                    }
                }
            }

            size--;

            return false;
        }


        public int hashCompute(int key) {
//            key ^= (key >>> 20) ^ (key >>> 12);
//            int hashCode = key ^ (key >>> 7) ^ (key >>> 4);
            //return hashCode % TABLE_SIZE;
            return key % TABLE_SIZE;
        }
    }

    private class HashEntry<E> {
        final E key;
        E value;

        public HashEntry<E> next;

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

        public void setValue(E val) {
            this.value = val;
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
