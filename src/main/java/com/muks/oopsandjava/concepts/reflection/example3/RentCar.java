package com.muks.oopsandjava.concepts.reflection.example3;

/*
 * Created by mukthar.ahmed on 12/4/15.
 */

public class RentCar {
    // private variables
    private int rate;
    private String type;

    // public vars
    public int price;

    public RentCar(int length) {
        if (length < 455) {
            type = "small";
            rate = 35;
        } else if ((length >= 455) && (length < 495)) {
            type = "mid-sized";
            rate = 45;
        } else if (length >= 495) {
            type = "large";
            rate = 55;
        }
    }


    public int getRate() {
        return rate;
    }

    public String getType() {
        return type;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void computeRentalCost(int numDays) {
        price = numDays * rate;
        System.out
                .println("The cost of your rental car is " + price + " euros");
    }
}
