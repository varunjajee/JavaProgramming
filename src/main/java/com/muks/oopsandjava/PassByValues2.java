package com.muks.oopsandjava;

/**
 * Created by mukthar.ahmed on 14/09/15.
 */
public class PassByValues2 {

    public static class Balloon {
        private String color;
        public Balloon() {}

        public Balloon(String c) {
            this.color = c;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    // main method()
    public static void main(String[] args) {

        Balloon red = new Balloon("Red"); //memory reference 50
        Balloon blue = new Balloon("Blue"); //memory reference 100

        swap(red, blue);
        System.out.println("red color = " + red.getColor());
        System.out.println("blue color = " + blue.getColor());


        foo(blue);
        System.out.println("Blue color = " + blue.getColor());
        System.out.println("Red color = " + red.getColor());

    }

    private static void foo(Balloon balloon) { //baloon=100
        System.out.println("\n+ Calling java swap.  ");
        balloon.setColor("Yellow"); //baloon=100

        balloon = new Balloon("Green"); //baloon=200
        System.out.println("+ New-1: " + balloon.getColor() );


        balloon.setColor("Blue"); //baloon = 200
        System.out.println("+ New-2: " + balloon.getColor() );
    }

    //Generic swap method
    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1=o2;
        o2=temp;
    }

}
