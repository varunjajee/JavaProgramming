package com.muks.trail_here;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Testing {

    public static void main(String[] args) {
//        int[] input = {1, 3, 2, 4, 5, 6, 3, 2};
//        countDup(input);

        getAllUniqueSubStrings("banana");
    }

    public static List<String> getAllUniqueSubStrings(String str) {
        List<String> set = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            for (int j = 0; j <= str.length() - i; j++) {
                String elem = str.substring(i, i +j);

                if (!set.contains(elem)) {
                    set.add(elem);
                }
            }
        }

        System.out.println("Unique sub strings = " + set.size());

        return set;
    }


    static void countDup(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            int key = num[i];

            System.out.println("key = " + key);
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, val+1);
            }
            else {
                map.put(key, 1);
            }
        }

        System.out.println(map.toString());

        int counter = 0;
        for (int k : map.keySet()) {
            System.out.println("key = " + k);
            if (map.get(k) > 1) {
                counter++;
            }
        }

        System.out.println("+ Counter: " + counter);

    }
}