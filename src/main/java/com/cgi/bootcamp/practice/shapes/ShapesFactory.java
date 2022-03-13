package com.cgi.bootcamp.practice.shapes;

/**
 * @author maxron
 * @version 1.0
 *
 * Löst die Abhängigkeit der Aufrufer an konkreten Klassen auf. Ein Aufrufer kennt nur noch die Schnittstelle und diese
 * Factory.
 * Durch den Typen enum und nur einer einzigen Sorte hiervon wird sichergestellt, dass nur eine Factory existieren kann,
 * Singleton (Einzelstück) Pattern.
 */
public enum ShapesFactory {

    // Singleton
    INSTANCE;

    // Factory
    public static IShape square(double length) {
        return new Square(length);
    }

    public static IShape rectangle(double height, double width) {
        return new Rectangle(height, width);
    }

    public static IShape circle(double radius) {
        return new Circle(radius);
    }
}
