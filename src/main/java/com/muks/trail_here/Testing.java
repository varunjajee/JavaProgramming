package com.muks.trail_here;

import java.util.Arrays;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        List<String> places = Arrays.asList("Buenos Aires", "Crdoba", "La Plata");
        List<Integer> arr = Arrays.asList(1,2,3);

        for (String str : places) {
            System.out.println("\n+ Before..." + str);
            if (str.equalsIgnoreCase("Crdoba")) {
                continue;
            }

            System.out.println("+ AFTER ..." + str);
        }
    }

}
