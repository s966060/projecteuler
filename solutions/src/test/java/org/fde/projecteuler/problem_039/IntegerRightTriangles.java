package org.fde.projecteuler.problem_039;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegerRightTriangles {
    class Triangle {
        int a, b, c;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Triangle{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

    class Triangles {
        private final int perimeter;
        private List<Triangle> list;

        public Triangles(int perimeter) {
            this.perimeter = perimeter;
            this.list = new ArrayList<>();
        }

        public void add(Triangle triangle) {
            this.list.add(triangle);
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override
        public String toString() {
            return "Triangles{" +
                    "perimeter=" + perimeter +
                    ", list.size()=" + list.size() +
                    ", list=" + list +
                    '}';
        }

        public int getPerimeter() {
            return perimeter;
        }
    }

    @Test
    public void integerRightTriangles() {
        List<Triangles> listOfTriangles = new ArrayList<>();

        for (int perimeter = 1; perimeter < 1_000; ++perimeter) {
            Triangles triangles = integerRightTriangles(perimeter);

            if (!triangles.isEmpty()) {
                listOfTriangles.add(triangles);
            }
        }

        Collections.sort(listOfTriangles, new Comparator<Triangles>() {
            @Override
            public int compare(Triangles o1, Triangles o2) {
                return -Integer.compare(o1.list.size(), o2.list.size());
            }
        });

        System.out.println("listOfTriangles = " + listOfTriangles);

        assertEquals(840, listOfTriangles.get(0).getPerimeter());
    }

    private Triangles integerRightTriangles(int perimeter) {
        Triangles triangles = new Triangles(perimeter);

        for (int a = 1; a <= (perimeter / 3); ++a) {
            for (int b = a + 1; b <= (perimeter - a); ++b) {
                int c = perimeter - a - b;

                if ((a + b + c) == perimeter) {
                    if (a * a + b * b == c * c) {
                        triangles.add(new Triangle(a, b, c));
                    }
                }
            }
        }

        return triangles;
    }
}
