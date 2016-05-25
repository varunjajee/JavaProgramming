package com.muks.Algorithm.AlgoBasics;

/**
 * Created by mukthar.ahmed on 5/14/16.
 *
 *  Search for a substring from input string and replace with another
 */
class SearchAndReplace {

    public static void main(String[] args) {
        String orig = "this is me here";
        System.out.println(replace(orig, "is", "ahmed") );

    }

    public static String replace(String orignal, String strToFind, String strToReplace) {
        if (strToFind.isEmpty()) {
            return orignal;
        }
        int pos = orignal.indexOf(strToFind);
        if (pos < 0) {
            return orignal;
        }
        return orignal.substring(0, pos) + strToReplace +
            replace(orignal.substring(pos + strToFind.length()),
                strToFind,
                strToReplace);
    }


    public static void searchAndReplace() {
        String sentence = "this brown fox was brown forever"; //sentence to replaced
        System.out.println(sentence);
        String source = "brown";
        String target = "black";

        char[] arr = sentence.toCharArray(); //convert the String to char array.

        if (source != target) {
            if (source.length() == target.length()) {
                int slength = source.length();
                int result = 0;
                int startIndex = 0;

                for (int i = 0; i < (sentence.length() - source.length() - 1); i++) {
                    int count = 0;
                    int j = 0;
                    startIndex = i;

                    while (j < source.length() - 1) {
                        if (sentence.charAt(i) == source.charAt(j)) {
                            count++;
                        }
                        i++;
                        j++;
                    }
                    if (count == source.length() - 1){
                        result = 1;
                        break;
                    }
                }

                if (result == 1) {
                    int j=0;
                    for (int i = startIndex; i < startIndex + slength; i++) {
                        arr[i] = target.charAt(j);
                        j++;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]); //displays the replaced String
        }
        //Console.ReadLine();
    }
}
