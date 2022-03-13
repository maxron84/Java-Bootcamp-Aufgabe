package com.cgi.bootcamp.practice;

import com.cgi.bootcamp.practice.shapes.ShapesFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author maxron
 * @version 1.0
 *
 * Der Textfile wird eingelesen und in einzelne Lines gesplittet. Die Lines werden nach bestimmten Regex-Patterns
 * evaluiert. Die einzelnen Zeichen der jeweiligen Lines werden als String- oder Doubleargumente
 * der ShapesFactory gereicht, diese gibt dann schlussendlich den gewünschten Shape zurück.
 */
public class GeoCalcFromFile {

    public static void main(String[] args) {
        GeoCalcFromFile geoCalcFromFile = new GeoCalcFromFile();
        try {
            geoCalcFromFile.go();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private String getFileContent(String path) throws IOException {
        return Files.readString(Path.of(path), StandardCharsets.UTF_8); // UTF 8 sollte hier immer passen
    }

    private List<String> getMatchedChars(CharSequence provider, String regex) {
        List<String> result = new ArrayList<String>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(provider);
        while(matcher.find()) {
             result.add(matcher.group());
        }

        return result;
    }

    private void go() throws IOException {
        String content = getFileContent(".\\templates\\shapes.txt");

        List<String> linesList = new ArrayList<String>(List.of(content.split("\\" + "n")));

        linesList.forEach((line) -> {
            String shapeType = (getMatchedChars(line, "[a-z]").get(0));

            List<Double> numParamList = new ArrayList<Double>();
            for (String str : getMatchedChars(line, "[0-9]+")) {
                numParamList.add(Double.parseDouble(str));
            }

            switch (shapeType) {
                case "s" -> System.out.println(ShapesFactory.square(numParamList.get(0)).info() + ",");
                case "r" -> System.out.println(ShapesFactory.rectangle(numParamList.get(0), numParamList.get(1)).info() + ",");
                case "c" -> System.out.println(ShapesFactory.circle(numParamList.get(0)).info() + ",");
                default -> System.err.println("Invalid arguments for ShapesFactory!");
            }
        });
    }
}
