package com.muks.Algorithm.AlgosOnString.Important;

/**
 * Created by mukthar.ahmed on 5/10/16.
 */
public class StringNumToInt {
    public static void main(String[] args) {
        String str = "1421";
        int num = stringToint(str);

        int rValue = Integer.compare(num, 1234);
        System.out.println("# return value: " + rValue);

    }

    public static int stringToint( String str ){
        int i = 0, number = 0;
        boolean isNegative = false;
        int len = str.length();

        if( str.charAt(0) == '-' ){
            isNegative = true;
            i = 1;
        }

        while ( i < len ){
            number *= 10;
            number += ( str.charAt(i) - '0' );
            i++;
        }

        if ( isNegative ) {
            number = -number;
        }
        return number;
    }
}
