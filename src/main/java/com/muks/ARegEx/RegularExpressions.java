package com.muks.ARegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mukthar.ahmed on 4/12/16.
 *
 *  - Complete RegEx reference class
 */

public class RegularExpressions {
    public static void main(String[] args) {
        //matchEmails();
        //matchDate();

        ipAddressValidators();
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
        String[] dates = {"2016-04-12",
            "2016/04/12",
            "2016_10_12",
            "2016_10_10"
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


}
