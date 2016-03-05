package com.muks.algo.SortingTechniques;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class StringSorting {
    public static void main(String[] args) {
        String inStr = "mukthar";
        alphabetical(inStr);
    }
    public static void alphabetical(String str) {

        char newArray[] = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            newArray[i] = str.charAt(i);
        }

        char t;
        int inStrLen = str.length();
        for(int i = 0; i < inStrLen - 1; i++) {

            for(int j = 0; j < inStrLen - 1 - i; j++) {

                if(newArray[j] > newArray[j+1]) {
                    t = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = t;
                }
            }
        }
        System.out.println("\nOriginal word : " + str);
        System.out.print("Sorted word : ");
        for(int m=0;m<inStrLen;m++)
            System.out.print(newArray[m]);
        System.out.print("\n");
    }
}
