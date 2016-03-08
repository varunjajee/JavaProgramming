package com.muks.DesignPatterns.creational.FactoryPattern;

/*
 * Created by mukthar.ahmed on 12/27/15.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestGenerateBill {

    public static void main(String[] args) {
        System.out.print("Enter the name of plan for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        try {
            String planName=br.readLine();
            System.out.print("Enter the number of units for bill will be calculated: ");

            GetPlanFactory planFactory = new GetPlanFactory();
            Plan plan = planFactory.getPlan(planName);

            int units=Integer.parseInt(br.readLine());

            System.out.println("+ Plan Name: " + planName + ", " + "Total Units: " + units);

            plan.getRate();
            plan.calculateBill(units);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
