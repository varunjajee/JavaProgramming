package com.muks.trail_here;

import java.util.ArrayList;
import java.util.List;

class Testing {

    public static void main(String[] args) {

        new Testing().testing();

    }


    public void testing() {
        List<Figure> figuresList = new ArrayList<>();

        Figure circle = new Circle();
        Figure square = new Square();
        Figure rectangle = new Rectangle();

        figuresList.add(circle);
        figuresList.add(square);
        figuresList.add(rectangle);

        System.out.println("# Name : " + figuresList.getClass().getName().getClass().getName() );
    }


    interface Figure {
        public void whoAmI();
    }	// end MyClass

    class Circle implements Figure {
        public void whoAmI() {
            System.out.println("# I am a Circle.");
        }
    }

    class Square implements Figure {
        public void whoAmI() {
            System.out.println("# I am a Square.");
        }
    }

    class Rectangle implements Figure {
        public void whoAmI() {
            System.out.println("# I am a Rectangle.");
        }
    }
}