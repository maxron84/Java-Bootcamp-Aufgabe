package com.cgi.bootcamp.practice.shapes;

import lombok.Getter;
import lombok.Setter;

/**
 * @author maxron
 * @version 1.0
 */
public class Square extends AInfoShape {

    @Getter @Setter
    private double length;

    public Square(double paramLength) {
        setLength(paramLength);
    }

    public double perimeter() {
        return 4 * getLength();
    }

    public double area() {
        return Math.pow(getLength(), 2.0d);
    }
}
