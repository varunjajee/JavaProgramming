package com.muks.DesignPatterns.structural.facade;

/**
 * Created by 15692 on 14/06/16.
 *
 * http://www.tutorialspoint.com/design_pattern/facade_pattern.htm
 *
 */
public class FacadeDemo {
    public static void main(String[] args) {
        ShapeMakerFacade shapeMaker = new ShapeMakerFacade();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
