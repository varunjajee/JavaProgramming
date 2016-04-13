package com.muks.oopsandjava.concepts.d_inheritance.extendedusage;

/*
 * What is 'super' keyword
 *  - It is used to call the super class's instance
 *
 *  Usage:
    1) super.<variable_name> refers to the variable of variable of parent class.
    2) super() invokes the constructor of immediate parent class.
    3) super.<method_name> refers to the method of parent class
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
