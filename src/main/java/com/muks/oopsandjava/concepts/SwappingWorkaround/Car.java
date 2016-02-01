package com.muks.oopsandjava.concepts.SwappingWorkaround;


class Car {
    int model, no;

    // Constructor
    Car(int model, int no) {
        this.model = model;
        this.no = no;
    }

    public void print() {
        System.out.println("Car no = " + no + ", model = " + model);
    }

}


