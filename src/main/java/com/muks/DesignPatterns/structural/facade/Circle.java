package com.muks.DesignPatterns.structural.facade;

/**
 * Created by 15692 on 14/06/16.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
