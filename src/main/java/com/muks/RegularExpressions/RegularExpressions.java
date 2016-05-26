package com.muks.RegularExpressions;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mukthar.ahmed on 4/12/16.
 *
 *  - Complete RegEx reference class
 *
 *
 * ? - zero or one
 * * - zero or more
 * + - one or more
 *
 */

public class RegularExpressions {
    public static void main(String[] args) {
        //matchEmails();
        //matchDate();

        //ipAddressValidators();

        String[] input = {"<div style=\\\"font-family:Arial",
            "http://www.ask-oxford.com/concise_blah",
            "web.archive.org/web","web.muks.in/web"};
        printDomains(input);
    }

    static void printDomains(String[] arr) {
        TreeSet<String> set = new TreeSet<String>();
        String domainRegEx = "(\\b[a-zA-Z0-9_-]+.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)\\b)";

        set.getClass().getName();

        Pattern inputPattern = Pattern.compile(domainRegEx);


        for (int i = 0; i < arr.length; i++) {
            Matcher matcher = inputPattern.matcher(arr[i]);

            if (matcher.find()) {
                String output = matcher.group();
                System.out.println(matcher.group() + ";");
                set.add(matcher.group());

            }

        }

//        int len = set.size();
//        Iterator<String> setObjs = set.iterator();
//        while (setObjs.hasNext()) {
//            System.out.print(setObjs.next());
//            len--;
//            if (len != 0) {
//                System.out.print(";");
//            }
//        }
    }

    private static void ipAddressValidators() {
        String[] ipAddresses = {
            "0.14.100.21",
            "10.14.100.21",
            "127.0.1.1",
            "192.168.1.1"
        };
        for (String ip : ipAddresses) {
            IPAddressRegEx(ip);

        }
    }



    /**
     *  IP Addresses
     *      - never starts with 0.1.1.1
     *      -
     *      */

    private static void IPAddressRegEx(String ipAddress) {
        String regEx = "(" +
            "^(1[1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$" +
            ")";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.find()) {
            System.out.println("# Found: " + matcher.group());
        }
    }

    /**
     * Date Field RegEx
     */
    private static void matchDate() {
        String[] dates = {
            "2016-04-12",
            "2016/04/12",
            "2016_10_12"
        };

        for (String date : dates) {
            matchDateField(date);
        }
    }



    private static void matchDateField(String date) {
        String dateRegEx = "(" +
            "(^2016)" +
            "(-|/|_)" +
            "(0[1-9]|1[0-2])" +
            "(-|/|_)" +
            "(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
            ")";

        Pattern pattern = Pattern.compile(dateRegEx);
        Matcher matcher = pattern.matcher(date);

        if (matcher.find()) {
            System.out.println("# Found: " + matcher.group());
        }
    }

    /**
     *  EMail Id RegEx
     */
    private static void matchEmails() {
        String[] mailIDs = {
            "mukthar.am@gmail.com",
            "Mukthar1.asd.last@gmail-inc.com"
        };
        regEgEmail(mailIDs);
    }

    /**
     * ? - zero or one
     * * - zero or more
     * + - one or more
     *
     * ========================
     * Logic:
     * [a-zA-Z0-0] - matches single occurrence of 1 char
     * .+          - "." matching previous char, "+" for one or more number of times
     * (.)         - Says strict match of "." character,
     * with "?"    - for zero or more number of occurrence
     *
     * @ - strict match
     * (-inc)?     - zero or more match of "-inc"
     * (.com$)     - String ending with ".com"
     */
    private static void regEgEmail(String[] email) {
        String emailRegExPattern = "(" +
            "^[a-zA-Z0-9].+((.)?[a-zA-Z0-0]+)?@[a-zA-Z]+(-inc)?(.com$)" +
            ")";

        System.out.println("# Using pattern: " + emailRegExPattern);
        Pattern pattern = Pattern.compile(emailRegExPattern);

        for (String mailIds : email) {
            Matcher matcher = pattern.matcher(mailIds);

            if (matcher.find()) {
                System.out.println("# Matched String: " + matcher.group());
            }
        }
    }

    private static String urlParser(String inString) {
        System.out.println("+ Parsing the string for a url - " + inString);

        Pattern urlPattern = Pattern.compile("(" +
            "(www|http|https)" +
            "(://)?(.)?" +
            "((\\w.)?)+" +
            "(.)(\\w)(.)(com)" +
            ")"
        );

        Matcher urlMatcher = urlPattern.matcher(inString);

        if (urlMatcher.find()) {
            return urlMatcher.group();
        } else {
            throw new NoSuchElementException("+ Couldn't find the required search pattern.");
        }
    }

}
