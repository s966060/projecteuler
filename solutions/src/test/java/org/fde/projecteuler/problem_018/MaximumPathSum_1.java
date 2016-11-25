package org.fde.projecteuler.problem_018;

import org.apache.commons.lang3.Validate;
import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.fde.util.Logger;
import org.fde.util.trianglemaximumpath.Line;
import org.fde.util.trianglemaximumpath.Triangle;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaximumPathSum_1 {
    @Test
    public void maximumPathSum_1() throws Exception {
        InputStream is = ClassUtil.getInputStream(this, "triangle.txt");
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

        Logger.log("triangle = " + triangle);
        Logger.log();
        Logger.log();

        Triangle newTriangle = new Triangle(triangle);

        while (newTriangle.canRollUp()) {
            newTriangle = newTriangle.rollUp();

            Logger.log("newTriangle = " + newTriangle);
            Logger.log();
            Logger.log();
        }

        assertEquals(1074, newTriangle.getTopValue());
    }
}
