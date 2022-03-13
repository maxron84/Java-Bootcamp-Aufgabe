package com.cgi.bootcamp.practice.shapes;

/**
 * @author maxron
 * @version 1.0
 * Gibt Typ und Berechnungen des Shapes als JSON formattiert aus. Prüfung mit jsonlint.com war erfolgreich.
 * Keine Reflection.
 */
public abstract class AInfoShape implements IShape {

    // Template
    public final String info() {
        // https://jsonlint.com/
        return "{\n\t\"type\": "
                + "\"" + name() + "\""
                + ",\n\t"
                + "\"perimeter\": "
                + RoundHelper.GetTwoDecimals(perimeter())
                + ",\n\t" + "\"area\": "
                + RoundHelper.GetTwoDecimals(area())

//                + "\n\t\"parameters\": {" // Reflection?
//                + "\n\t\t\"param1\": ..."
//                + "\n\t\t\"param2\": ..."
//                + "\n\t}"

                + "\n}";
    }
}
