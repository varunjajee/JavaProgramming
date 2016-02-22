package com.muks.regex;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by mukthar.ahmed on 1/19/16.
 */
public class RegExParsing {

    public static void main(String[] args) {
        String url = "Here's my URL https://i.w.inmobi.com, go for it.";
        //System.out.println("+ Parsed URL = " + urlParser(url));

        String inIpString = "10.24.100.44";
        System.out.println(ipMatcher(inIpString));
    }


    private static String ipMatcher(String inString) {
        System.out.println("+ Looking for an Ip match from the input - " + inString);

        Pattern ipPattern = Pattern.compile("(\\d+).2(\\d+).(\\d+).(\\d+)");

        Matcher ipMatcher = ipPattern.matcher(inString);

        if (ipMatcher.find()) {
            return ipMatcher.group();
        }
        else {
            System.out.println("+ Didn't find... ");
            throw new NoSuchElementException("+ Couldn't find the Ip pattern.");
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
