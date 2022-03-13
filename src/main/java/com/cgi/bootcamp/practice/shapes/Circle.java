package com.cgi.bootcamp.practice.shapes;

import lombok.Getter;
import lombok.Setter;

/**
 * @author maxron
 * @version 1.0
 */
public class Circle extends AInfoShape {

    @Getter @Setter
    private double radius;

    public Circle(double paramRadius) {
        setRadius(paramRadius);
    }

    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }

    public double area() {
        return Math.PI * getRadius() * getRadius();
    }
}
