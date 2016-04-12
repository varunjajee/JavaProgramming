package com.muks.ARegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mukthar.ahmed on 4/12/16.
 */
public class RegularExpressions {
    public static void main(String[] args) {
        matchEmails();
    }

    private static void matchEmails() {
        String[] mailIDs = {
            "mukthar.am@gmail.com",
            "Mukthar1.asd.last@gmail-inc.com"
        };
        regEgEmail(mailIDs);
    }
    private static void regEgEmail(String[] email) {
        String regegPattern2 = "(" +
            "^[a-zA-Z0-9].+((.)?[a-zA-Z0-0]+)?@[a-zA-Z]+(-inc)?(.com$)" +
            ")";

        /**
         * Logic:
         [a-zA-Z0-0] - matches single occurrence of 1 char
         .+          - "." matching previous char, "+" for one or more number of times
         (.)         - Says strict match of "." character,
         with "?"    - for zero or more number of occurrence
         @           - strict match
         (-inc)?     - zero or more match of "-inc"
         (.com$)     - String ending with ".com"
         */

        System.out.println("# Using pattern: " + regegPattern2);
        Pattern pattern = Pattern.compile(regegPattern2);

        for (String mailIds : email) {
            Matcher matcher = pattern.matcher(mailIds);

            if (matcher.find()) {
                System.out.println("# Matched String: " + matcher.group());
            }
        }
    }
}
