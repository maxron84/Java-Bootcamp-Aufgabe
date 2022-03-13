package com.cgi.bootcamp.practice.shapes;

import lombok.Getter;
import lombok.Setter;

/**
 * @author maxron
 * @version 1.0
 */
public class Rectangle extends AInfoShape {

    @Getter @Setter
    private double height, width;

    public Rectangle(double paramHeight, double paramWidth) {
        setHeight(paramHeight);
        setWidth(paramWidth);
    }

    public double perimeter() {
        return 2 * (getHeight() + getWidth());
    }

    public double area() {
        return getHeight() * getWidth();
    }
}
