package com.cgi.bootcamp.practice.shapes;

/**
 * @author maxron
 * @version 1.0
 */
public final class RoundHelper {

    public static double GetTwoDecimals(double x) {
        return Math.rint(x * 100) / 100.;
    }
}
