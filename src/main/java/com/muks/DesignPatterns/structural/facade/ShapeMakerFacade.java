package com.muks.DesignPatterns.structural.facade;

/**
 * Created by 15692 on 14/06/16.
 */
public class ShapeMakerFacade {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMakerFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
