package com.muks.IntrvAlgorithms.GoMapper;

/*
 * Created by mukthar.ahmed on 1/29/16.
 */
public class UrlShortner {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int    BASE     = ALPHABET.length();

    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();

        while ( num > 0 ) {
            sb.append( ALPHABET.charAt((int) (num % BASE)) );
            num /= BASE;
        }

        return sb.reverse().toString();
    }

    public static int decode(String str) {
        int num = 0;

        for ( int i = 0, len = str.length(); i < len; i++ ) {
            System.out.println("Alphabet = " + ALPHABET.indexOf( str.charAt(i)));
            System.out.println("Base = " + BASE);
            num = num * BASE + ALPHABET.indexOf( str.charAt(i) );

            System.out.println("num = " + num);
        }

        return num;
    }

    public static void main(String[] args) {
        //System.out.println(encode(12345));


        System.out.println(decode("www.google.com/"));

    }
}

