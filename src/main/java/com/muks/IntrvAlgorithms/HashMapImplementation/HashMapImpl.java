package com.muks.IntrvAlgorithms.HashMapImplementation;


public class HashMapImpl {

    static class HashMap {
        int SIZE_OF_TABLE = 128;
        HashEntry[] table;

        HashMap() {
            table = new HashEntry[SIZE_OF_TABLE];
            for (int i = 0; i < SIZE_OF_TABLE; i++) {
                table[i] = null;
            }
        }

        public void put(int key, int value) {
            int hashIndex = hashCodeNew(key);
            System.out.println("# HashIndex = " + hashIndex);

            HashEntry newHashEntry = new HashEntry(key, value);

            if (table[hashIndex] == null) {
                table[hashIndex] = newHashEntry;
            } else {
                HashEntry runner = table[hashIndex];
                while (runner.next != null) {
                    if (runner.key == newHashEntry.key) {
                        runner.value = newHashEntry.value;
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

        public int get(int key) {
            int index = hashCodeNew(key);

            if (table[index] == null) {
                return -1;
            }
            else {
                HashEntry runner = table[index];
                if (runner.key == key) {
                    return runner.value;
                }
                while (runner.next != null) {
                    if (runner.key == key) {
                        return runner.value;
                    }
                }
                return -1;
            }
        }

        public int hashCodeNew(int h) {
//            h ^= (h >>> 20) ^ (h >>> 12);
//            int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
            //return hashCode % SIZE_OF_TABLE;
            return h % SIZE_OF_TABLE;
        }
    }

    static class HashEntry {
        int key;
        int value;
        HashEntry next = null;

        HashEntry() {
        }

        public HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(10, 20);
        hashMap.put(20, 11);
        hashMap.put(21, 1);
        hashMap.put(20, 10);

        int value = hashMap.get(20);
        System.out.println("# Val = " + value);

    }

}
