package com.cgi.bootcamp.practice;

import com.cgi.bootcamp.practice.shapes.IShape;

import static com.cgi.bootcamp.practice.shapes.ShapesFactory.circle;
import static com.cgi.bootcamp.practice.shapes.ShapesFactory.rectangle;
import static com.cgi.bootcamp.practice.shapes.ShapesFactory.square;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Verschiebe diese Klasse in das entsprechende Package im 'src/main/java' Verzeichnis des Projektes.
 * Wenn Du alle Aufgaben bisher korrekt ausgeführt hast, sollte das Programm kompilieren und sich ausführen lassen.
 * Sollte es Compile-Probleme geben, versuche Deinen Code compatibel zu machen.
 * Validiere die Ausgabe mit https://jsonlint.com/
 */
public class ShapeApp {

	public static void main(String[] args) {

		List<IShape> shapes = new ArrayList<IShape>();
		shapes.add(square(5d));
		shapes.add(rectangle(3d, 4d));
		shapes.add(circle(7d));

		Optional<String> shapeSnippets = (Optional<String>) shapes.stream()
				.map(com.cgi.bootcamp.practice.shapes.IShape::info)
				.reduce((a, b) -> a + ",\n" + b);

		shapeSnippets.ifPresent(snippets -> System.out.println("["+snippets+"]"));
	}
}
