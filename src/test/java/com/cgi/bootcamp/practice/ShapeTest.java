package com.cgi.bootcamp.practice;

import com.cgi.bootcamp.practice.shapes.ShapesFactory;
import com.cgi.bootcamp.practice.shapes.IShape;
import com.cgi.bootcamp.practice.shapes.RoundHelper;

/**
 * @author maxron
 * @version 1.0
 *
 * Die Tests erwarten eine Behauptung und geben zurück ob diese der Tatsache entspricht. Ausgabe erfolgt als
 * normaler String, kein StringBuilder. Es wird hier keine Reflection verwendet.
 */
public class ShapeTest {

    private IShape proband;
    private final String hardcodedAreaName = "area()", hardcodedPerimeterName = "perimeter()"; // Reflection?

    private String getText(IShape shape, String hardcodedMethodName, double x, double y) {
        return shape.name() + "(" + RoundHelper.GetTwoDecimals(x)
                + ")." + hardcodedMethodName + " should be " + RoundHelper.GetTwoDecimals(y) + " but was: ";
    }
    private String getText(IShape shape, String hardcodedMethodName, double x, double y, double z) {
        return shape.name() + "(" + RoundHelper.GetTwoDecimals(x)
                + ", " + RoundHelper.GetTwoDecimals(y) + ")." + hardcodedMethodName + " should be "
                + RoundHelper.GetTwoDecimals(z) + " but was: ";
    }

    private void printText(String text, double actual) {
        System.err.println(text + RoundHelper.GetTwoDecimals(actual));
    }

    private boolean checkEqual(double actual, double expected, String text) {
        boolean assertion = (actual == expected);
        if (!assertion) { printText(text, actual); }

        return assertion;
    }

    public boolean testSquare(double length, double expectedArea, double expectedPerimeter) {
        proband = ShapesFactory.square(length);

        return checkEqual(proband.area(), expectedArea, getText(proband, hardcodedAreaName, length, expectedArea))
                & checkEqual(proband.perimeter(), expectedPerimeter, getText(proband, hardcodedPerimeterName, length, expectedPerimeter));
    }

    public boolean testRectangle(double height, double width, double expectedArea, double expectedPerimeter) {
        proband = ShapesFactory.rectangle(height, width);

        return checkEqual(proband.area(), expectedArea, getText(proband, hardcodedAreaName, height, width, expectedArea))
                & checkEqual(proband.perimeter(), expectedPerimeter, getText(proband, hardcodedPerimeterName, height, width, expectedPerimeter));
    }

    public boolean testCircle(double radius, double expectedArea, double expectedPerimeter) {
        proband = ShapesFactory.circle(radius);

        return checkEqual(proband.area(), expectedArea, getText(proband, hardcodedAreaName, radius, expectedArea))
                & checkEqual(proband.perimeter(), expectedPerimeter, getText(proband, hardcodedPerimeterName, radius, expectedPerimeter));
    }
}
