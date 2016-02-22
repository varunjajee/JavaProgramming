package com.muks.IntrvAlgorithms.GoMapper;

import java.util.HashMap;
import java.util.Random;

/*
 * Created by mukthar.ahmed on 1/29/16.
 */
public class URLShortnerFull {
        // storage for generated keys
        private HashMap<String, String> KEY_MAP; // key-url map
        private HashMap<String, String> VALUE_MAP;// url-key map to quickly check

        /* whether an url is already entered in our system
            Use this attribute to generate urls for a custom DOMAIN_DEFAULT name
            defaults to http://fkt.in
        */
        private String DOMAIN_DEFAULT;

        private char MY_CHARS[]; // CHAR array used for character to number mapping - [a-zA-Z0-9]
        private Random MY_RAND; // Random object used to generate random integers
        private int KEY_LENGTH; // the key length in URL defaults to 8

        // Default Constructor
        URLShortnerFull() {
            KEY_MAP = new HashMap<>();
            VALUE_MAP = new HashMap<>();
            MY_RAND = new Random();
            KEY_LENGTH = 8;

            MY_CHARS = new char[62];
            for (int i = 0; i < 62; i++) {
                int j = 0;

                if (i < 10) {
                    j = i + 48;

                } else if (i > 9 && i <= 35) {
                    j = i + 55;

                } else {
                    j = i + 61;

                }

                MY_CHARS[i] = (char) j;
                System.out.println(" => j = " + j + ", Char = " + (char) j);
                for (char ch : MY_CHARS) {
                    System.out.print(" " + ch);
                }
            }
            System.out.println("");
            DOMAIN_DEFAULT = "http://fkt.in";
        }

        // Constructor which enables you to define tiny URL key length and base URL name
        URLShortnerFull(int length, String newDomain) {
            this();
            this.KEY_LENGTH = length;
            if (!newDomain.isEmpty()) {
                newDomain = sanitizeURL(newDomain);
                DOMAIN_DEFAULT = newDomain;
            }
        }

        // shortenURL
        // the public method which can be called to shorten a given URL
        public String shortenURL(String longURL) {
            String shortURL = "";

            if (validateURL(longURL)) {
                longURL = sanitizeURL(longURL);

                if (VALUE_MAP.containsKey(longURL)) {
                    shortURL = DOMAIN_DEFAULT + "/" + VALUE_MAP.get(longURL);
                } else {
                    shortURL = DOMAIN_DEFAULT + "/" + getKey(longURL);
                }
            }
            // add http part
            return shortURL;
        }

        // expandURL
        // public method which returns back the original URL given the shortened url
        public String expandURL(String shortURL) {
            String longURL = "";
            String key = shortURL.substring(DOMAIN_DEFAULT.length() + 1);
            longURL = KEY_MAP.get(key);
            return longURL;
        }

        // Validate URL
        // not implemented, but should be implemented to check whether the given URL
        // is valid or not
        boolean validateURL(String url) {
            return true;
        }

        /*  =====================================================================================
        sanitizeURL()
            - This method should take care various issues with a valid url
            - e.g. (1) www.google.com,www.google.com/, http://www.google.com,
            - http://www.google.com/
            - all the above URL should point to same shortened URL
            - There could be several other cases like these.
        */
        String sanitizeURL(String url) {
            if (url.substring(0, 7).equals("http://"))
                url = url.substring(7);

            if (url.substring(0, 8).equals("https://"))
                url = url.substring(8);

            if (url.charAt(url.length() - 1) == '/')
                url = url.substring(0, url.length() - 1);
            return url;
        }

        /*
         * Get Key method
         */
        private String getKey(String longURL) {
            String key = generateKey();
            KEY_MAP.put(key, longURL);
            VALUE_MAP.put(longURL, key);
            return key;
        }

        // generateKey
        private String generateKey() {
            String key = "";
            boolean flag = true;
            while (flag) {
                key = "";
                System.out.println("+ KEY_LENGTH = " + KEY_LENGTH);
                for (int i = 0; i <= KEY_LENGTH; i++) {
                    int rand = MY_RAND.nextInt(62);

                    key += MY_CHARS[rand];

                    System.out.println("+ i = " + i + ", Rand = " + rand + ", Key = " + key);
                }

                 System.out.println("Final Key = "+ key);
                if (!KEY_MAP.containsKey(key)) {
                    flag = false;
                }
            }
            return key;
        }

        // test the code
        public static void main(String args[]) {
            URLShortnerFull u = new URLShortnerFull(5, "www.tinyurl.com/");
            String urls[] = { "www.google.com/", "http://bob-pso.app.uj1.inmobi.com:8081/bob/"};


         //            , "www.google.com",
//                    "http://www.yahoo.com", "www.yahoo.com/", "www.amazon.com",
//                    "www.amazon.com/page1.php", "www.amazon.com/page2.php",
//                    "www.flipkart.in", "www.rediff.com", "www.techmeme.com",
//                    "www.techcrunch.com", "www.lifehacker.com", "www.icicibank.com" };

            for (int i = 0; i < urls.length; i++) {
                System.out.println("URL:" + urls[i] + "\tTiny: "
                        + u.shortenURL(urls[i]) + "\tExpanded: "
                        + u.expandURL(u.shortenURL(urls[i])));
            }
        }
    }
