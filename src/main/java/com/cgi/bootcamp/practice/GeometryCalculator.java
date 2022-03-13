package com.cgi.bootcamp.practice;

import com.cgi.bootcamp.practice.shapes.ShapesFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author maxron
 * @version 1.0
 *
 * Der Nutzer wählt den gewünschten Shape und gibt die Maße ein, die ShapesFactory gibt das Ergebnis zurück.
 */
public class GeometryCalculator {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private double x, y;

    public static void main(String[] args) {
        GeometryCalculator geoCalc = new GeometryCalculator();
        System.out.println("\n---\nWelcome to the Geometry Calculator!\n---\n");
        try {
            geoCalc.handleConsoleInOut();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void handleConsoleInOut() throws IOException {
        do {
            System.out.println("Choose your shape: (ENTER to exit)\ns: Square\nr: Rectangle\nc: Circle");
            String input = bufferedReader.readLine();

            try {
                switch (input) {
                    case "s" -> System.out.println(getResultSquare());
                    case "r" -> System.out.println(getResultRectangle());
                    case "c" -> System.out.println(getResultCircle());
                    case "" -> System.exit(0);
                    default -> System.err.println(input + " is not a valid input!\n");
                }
            } catch (Exception ex) {
                System.err.println("ERROR - " + ex.getMessage() + " - Please provide numbers only!");
            }

        } while (bufferedReader.readLine() != null);
    }

    private String getResultSquare() throws IOException {
        System.out.println("Square length: ");
        x = Double.parseDouble(bufferedReader.readLine());

        return ShapesFactory.square(x).info();
    }

    private String getResultRectangle() throws IOException {
        System.out.println("\nRectangle height: ");
        x = Double.parseDouble(bufferedReader.readLine());
        System.out.println("\nRectangle width: ");
        y = Double.parseDouble(bufferedReader.readLine());

        return ShapesFactory.rectangle(x, y).info();
    }

    private String getResultCircle() throws IOException {
        System.out.println("\nCircle radius: ");
        x = Double.parseDouble(bufferedReader.readLine());

        return ShapesFactory.circle(x).info();
    }
}
