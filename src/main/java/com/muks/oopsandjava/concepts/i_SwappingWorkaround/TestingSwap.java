package com.muks.oopsandjava.concepts.i_SwappingWorkaround;


/**  ============= How workaround for swapping of objects work in java =============

    - Create a wrapper class which takes the object class
    - Your swap method should consume Wrapper class and swap wrapper.carObject by each-other
 */

public class TestingSwap {

    public static void swap(Car c1, Car c2) {
        Car temp = c1;
        c1 = c2;
        c2 = temp;
    }

    /**
     * Swapping here is called, exchanging of objects
     * */
    public static void swap(CarWrapper cw1, CarWrapper cw2) {
        Car temp = cw1.carObject;
        cw1.carObject = cw2.carObject;
        cw2.carObject = temp;
    }


    public static void main(String[] args) {
        /** this doesn't swap objects successfully */
//        Car c1 = new Car(101, 1);
//        Car c2 = new Car(202, 2);
//        swap(c1, c2);
//        c1.print();
//        c2.print();

        /** Successful swapping */
        Car c1 = new Car(101, 1);
        Car c2 = new Car(202, 2);

        CarWrapper cw1 = new CarWrapper(c1);
        CarWrapper cw2 = new CarWrapper(c2);

        swap(cw1, cw2);
        cw1.carObject.print();
        cw2.carObject.print();
    }


}
