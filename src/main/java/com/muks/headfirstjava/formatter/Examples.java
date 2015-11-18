package com.muks.headfirstjava.formatter;

import java.util.Date;

/**
 * Created by mukthar.ahmed on 10/19/15.
 */
public class Examples {
    public static void main(String[] args) {
        System.out.println("Full Date: " + String.format("%tc", new Date()));

        System.out.println("Just the time: " + String.format("%tr", new Date()));

        Date dt = new Date();
        System.out.println(String.format("%tA, %tB %td", dt, dt, dt));
    }
}
