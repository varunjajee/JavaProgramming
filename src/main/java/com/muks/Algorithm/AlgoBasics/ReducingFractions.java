package com.muks.Algorithm.AlgoBasics;

/**
 * Created by mukthar.ahmed on 5/25/16.
 *
 * Asked in hackerrank.com (AppLift)
 */
public class ReducingFractions {

    public static void main(String[] args) {

        String[] input = {"825/1161", "1092/1041"};
        String[] output = ReduceFraction(input);
        for (String str : output) {
            System.out.println(str);
        }
    }


    static String[] ReduceFraction(String[] fractions) {
        String[] output = new String[fractions.length];
        int index = -1;

        for (String str : fractions) {
            String[] splits = str.split("/");

            int neumerator = Integer.parseInt(splits[0]);
            int denominator = Integer.parseInt(splits[1]);


            int smaller = neumerator < denominator ? neumerator : denominator;
            int HCF = -1;
            for (int i = smaller; i > 0; --i) {
                if (neumerator % i == 0 && denominator % i == 0) {
                    HCF = i;
                    //System.out.println((neumerator / HCF) + "/" + (denominator / HCF));
                    output[++index] = (neumerator / HCF) + "/" + (denominator / HCF);
                    break;
                }
            }
        }

        return output;
    }
}
