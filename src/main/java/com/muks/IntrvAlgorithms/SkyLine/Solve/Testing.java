package com.muks.IntrvAlgorithms.SkyLine.Solve;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */

public class Testing {

    public static void main(String[] args) {
        Building[] buildings = {
                new Building(1, 5, 11),
                new Building(2, 7, 6),
                new Building(3, 9, 13),
                new Building(12, 16, 7),
                new Building(14, 25, 3),
                new Building(19, 22, 18),
                new Building(23, 29, 13),
                new Building(24, 28, 4)
        };


        System.out.println("+ Your buildings are: ");
        for (int i = 0; i < buildings.length; i++) {
            buildings[i].print();
        }
        System.out.println("\n");


        System.out.println("+ Traversing through all the buildings");
        SkyLine res = new SkyLine(buildings.length * 4);

    }

}
