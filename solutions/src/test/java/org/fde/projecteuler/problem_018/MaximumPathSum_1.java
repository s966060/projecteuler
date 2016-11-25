package org.fde.projecteuler.problem_018;

import org.fde.util.Logger;
import org.fde.util.trianglemaximumpath.Triangle;
import org.fde.util.trianglemaximumpath.TriangleLoader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumPathSum_1 {
    @Test
    public void maximumPathSum_1() throws Exception {
        String fileName = "triangle.txt";
        final Triangle triangle = new TriangleLoader().loadTriangle(fileName);

        Logger.log("triangle = " + triangle);
        Logger.log();
        Logger.log();

        Triangle newTriangle = triangle.solveTriangle();

        assertEquals(1074, newTriangle.getTopValue());
    }
}
