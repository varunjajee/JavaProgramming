package com.muks.headfirstjava.inheritance.extendedusage;

/**
 * Created by mukthar.ahmed on 10/7/15.
 */
public class BuzzwordsReport extends Report {

    void runReport() {
        super.runReport();
        System.out.println("+ Running sub-class reports from BuzzwordsReport()");
    }

    public static void main(String[] args) {
        /*
        Note:
        - If we want the behavior of super class plus override its implementation, use as above.
         */
        BuzzwordsReport buzzwordsReport = new BuzzwordsReport();
        buzzwordsReport.runReport();
    }
}
