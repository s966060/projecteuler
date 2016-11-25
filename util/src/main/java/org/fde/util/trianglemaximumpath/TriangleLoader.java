package org.fde.util.trianglemaximumpath;

import org.apache.commons.lang3.Validate;
import org.fde.util.ClassUtil;
import org.fde.util.LineReader;

import java.io.InputStream;
import java.util.Scanner;

public class TriangleLoader {
    public Triangle loadTriangle(String fileName) throws Exception {
        InputStream is = ClassUtil.getInputStream(this, fileName);
        Validate.notNull(is);

        final Triangle triangle = new Triangle();

        new LineReader(is) {
            @Override
            public void readLine(String input) throws Exception {
                Scanner scanner = new Scanner(input);

                Line line = new Line();

                while (scanner.hasNextInt()) {
                    line.add(scanner.nextInt());
                }

                triangle.add(line);
            }
        }.readAll();
        return triangle;
    }
}
