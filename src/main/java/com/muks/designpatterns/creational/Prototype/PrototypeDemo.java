package com.muks.DesignPatterns.creational.Prototype;

/*
 * Created by mukthar.ahmed on 12/28/15.
 */
public class PrototypeDemo {

    public static void main(String[] args) {
        int eid = 435;
        String ename = "Mukthar";
        String edesignation = "Tech Lead";
        String eaddress = "Bangalore";
        double esalary = 9999.99;

        EmployeeRecord e1 = new EmployeeRecord(eid,ename,edesignation,esalary,eaddress);
        e1.showEmployeeRecord();
        System.out.println("\n");

        EmployeeRecord emp2 = (EmployeeRecord) e1.getClone();
        emp2.showEmployeeRecord();
    }
}
