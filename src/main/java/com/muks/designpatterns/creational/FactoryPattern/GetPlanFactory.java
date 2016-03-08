package com.muks.DesignPatterns.creational.FactoryPattern;

/**
 * Created by mukthar.ahmed on 12/27/15.
 */
public class GetPlanFactory {

    // get plan
    public Plan getPlan(String planType) {

        if (planType == null || planType.equals("")) {
            return null;
        }

        if (planType.equalsIgnoreCase("commercial")) {
            return new CommercialPlan();
        }
        else if (planType.equalsIgnoreCase("domestic")) {
            return new DomensticPlan();
        }
        else if (planType.equalsIgnoreCase("institutional")) {
            return new InstitutionalPlan();
        }

        return null;
    }
}
