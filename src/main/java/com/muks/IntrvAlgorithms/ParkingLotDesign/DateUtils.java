package com.muks.IntrvAlgorithms.ParkingLotDesign;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mukthar.ahmed on 3/7/16.
 */
public class DateUtils {

    private DateUtils() {}

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static void DateDiff(DateFormat dateFormat, String date1, String date2) {
        System.out.println("+ D1 = " + date1 + ", D2 = " + date2);

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = dateFormat.parse(date1);
            d2 = dateFormat.parse(date2);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
