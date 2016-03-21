package com.muks.IntrvAlgorithms.HashMapImplementation;

/**
 * Created by mukthar.ahmed on 3/18/16.
 */
public class TestingHashMap {
    public static void main(String[] args) {
        HashMapCustom mapCustom = new HashMapCustom();

        mapCustom.put(1, 2);
        mapCustom.put(10, 3);

        mapCustom.remove(1);
        mapCustom.put(1, 2222);

        System.out.println(mapCustom.get(1));
    }
}
