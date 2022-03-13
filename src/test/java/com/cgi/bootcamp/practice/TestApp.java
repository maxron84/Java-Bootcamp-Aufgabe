package com.cgi.bootcamp.practice;

public class TestApp {
    public static void main(String[] args) {
        String success = ".\nTests SUCCEEDED!\n";
        String fail = ".\nTests FAILED!\n";
        ShapeTest shapeTest = new ShapeTest();

        // Alle Tests gelingen
        if (shapeTest.testSquare(0d, 0d, 0d)
                & shapeTest.testRectangle(0d,0d,0d,0d)
                & shapeTest.testCircle(0d, 0d,0d)) {
            System.out.println(success);
        }
        else {
            System.err.println(fail);
        }

        // Tests gelingen nur teilweise
        if (shapeTest.testSquare(0d, 1d, 0d)
                & shapeTest.testRectangle(0d,0d,0d,1d)
                & shapeTest.testCircle(256d, 1d,0d)) {
            System.out.println(success);
        }
        else {
            System.err.println(fail);
        }

        // Alle Tests schlagen fehl
        if (shapeTest.testSquare(0d, 1d, 1d)
                & shapeTest.testRectangle(0d,0d,1d,1d)
                & shapeTest.testCircle(128d, 1d,1d)) {
                System.out.println(success);
        }
        else {
            System.err.println(fail);
        }
    }
}
