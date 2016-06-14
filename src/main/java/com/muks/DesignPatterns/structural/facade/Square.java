package com.muks.DesignPatterns.structural.facade;

/**
 * Created by 15692 on 14/06/16.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
