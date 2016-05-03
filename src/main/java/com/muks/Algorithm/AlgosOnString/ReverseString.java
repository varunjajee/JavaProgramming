package com.muks.Algorithm.AlgosOnString;

public class ReverseString {

    public static void main(String[] args) {
        //System.out.println("+++ " + rev("this is me") );

        //System.out.println("+++ " + reverseByMid("this is me") );

        reverseByMid("this is me");
    }


    /** Traversing till the mid length */
    private static String reverseByMid(String str) {
        int n = str.length();

        char[] arr = str.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            char temp = arr[n - 1 - i];
            arr[n - 1 - i] = arr[i];
            arr[i] = temp;
        }

        System.out.println(new String(arr) );

        return new String(arr);
    }



    // ##################################################################################################
    // Method to mirror string:
    public static String reverseByRecursion(String str) {
        int length = str.length();
        System.out.println("+++ : " + str);

        if (length <= 1) {
            return str;
        }

        char c = str.charAt(length - 1);
        System.out.println(" C: " + c);
        return c + reverseByRecursion(str.substring(0, length - 1));

    } // mirror()

    // ##################################################################################################
    public static String rev(String orig) {
        char[] str = orig.toCharArray();
        int p1 = 0;
        int p2 = str.length - 1;

        //for (int i=0; i < str.length(); i++) {

        while (p1 <= p2) {
            System.out.println(" p1 != p2 " + p1 + " " + p2);
            char temp = str[p1];
            str[p1] = str[p2];
            str[p2] = temp;
            p1++;
            p2--;
            System.out.println(" p1 != p2 " + str[p1] + " " + str[p2]);

        }
        //}
        return new String(str);
    }
}
