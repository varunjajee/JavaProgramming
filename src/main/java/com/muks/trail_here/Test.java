package com.muks.trail_here;

/**
 * Created by mukthar.ahmed on 12/22/15.
 */


public class Test {

    public static void main(String[] args) {
        String str = "mukthar ahmed";
        int pivot = 4;

        for (int i = 0; i < pivot; i++) {
            char popd = str.charAt(0);

            str = str + popd;
            str = str.substring(1, str.length());
            System.out.println("= alast = " + str);
        }
    }

}
