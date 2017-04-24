package com.muks.SOLID.OpenClosedPrinciple;

/**
 * Created by 300000511 on 24/04/17

 *                      - A object must be "Open" for extension and "Closed" for modifications
 *                      - Requirements can keep getting added and hence open for extension and the

 * What does it mean?? It means that your classes should be designed such a way that whenever fellow developers wants
 * to change the flow of control in specific conditions in application, all they need to extend your class and
 * override some functions and that’s it.
 */


/**
 *  In the below example, Shapes are abstracted so that they are open for extension later the appropriate
 *  shapes are closed for modification with implementation by having "final" at Area() method.
 */
public class OpenClosed {

    public abstract class Shape {
        public abstract double Area();
    }

    public class Rectangle extends Shape {
        private double width = 0.0;
        private double height = 0.0;

        public Rectangle(double w, double h) {
            this.width = w;
            this.height = h;
        }

        public double getWidth() {
            return this.width;
        }

        public double getHeight() {
            return this.height;
        }

        @Override
        public final double Area() {
            return (this.width * this.height);
        }
    }


    public class Circle extends Shape {
        private double radius = 0.0;
        public Circle(double ra) {
            this.radius = ra;
        }

        public double getRadius() { return this.radius;  }

        @Override
        public final double Area() {
            return (this.radius*this.radius*Math.PI);
        }
    }


}
