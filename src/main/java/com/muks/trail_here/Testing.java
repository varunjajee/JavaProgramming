package com.muks.trail_here;


import com.muks.DSC.HashMap.HashMapOpenAddressing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Testing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        int testStudents = Integer.parseInt(scanner.nextLine());

        String[] names = new String[testStudents];
        for (int i = 0; i < testStudents; i++) {
            String name = scanner.nextLine();
            names[i] = name;
        }

        HashMap<Character, Boolean> map = new HashMap<>();
        boolean identify = true;

        for (String str : names) {
            char ch = str.charAt(0);

            if ( !map.containsKey(ch) ) {
                map.put(ch, true);
            }
            else {
                identify = false;
            }
        }

        if (identify) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}