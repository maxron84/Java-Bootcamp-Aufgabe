package com.cgi.bootcamp.practice.shapes;

/**
 * @author maxron
 * @version 1.0
 */
public interface IShape {

    double perimeter();
    double area();
    String info();

    default String name() {
        return getClass().getSimpleName();
    }
}
