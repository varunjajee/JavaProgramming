package com.muks.SOLID.OpenClosedPrinciple;

/**
 * Created by 300000511 on 24/04/17.
 */
public class GoodAndBadExamples {
    /** Open-Close Principle - Bad example */
    class GraphicEditor {
        public void drawShape(Shape s) {
            if (s.m_type == 1)
                drawRectangle(new Rectangle());

            else if (s.m_type == 2)
                drawCircle(new Circle());
        }

        void drawCircle(Circle r) {
            System.out.println("Drawing circle");
        }
        void drawRectangle(Rectangle r) {
            System.out.println("Drawing rectangle");
        }
    }

    class Shape {
        int m_type;
    }

    class Rectangle extends Shape {
        Rectangle() {
            super.m_type=1;
        }
    }

    class Circle extends Shape {
        Circle() {
            super.m_type=2;
        }
    }



    /** Good Open-closed example */
    // Open-Close Principle - Good example
    class GraphicEditorGood {
        public void drawShape(ShapeGood s) {
            s.draw();
        }
    }

    abstract class ShapeGood {
        public abstract void draw();
    }

    class RectangleGood extends ShapeGood  {
        public void draw() {
            // draw the rectangle
        }
    }
}
