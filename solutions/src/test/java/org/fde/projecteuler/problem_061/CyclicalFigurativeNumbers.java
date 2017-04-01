package org.fde.projecteuler.problem_061;

import org.fde.projecteuler.problem_061.figurative_numbers.*;
import org.junit.Test;

import static org.fde.projecteuler.problem_061.FigurativeNumbers.createFigurativeNumbers;

public class CyclicalFigurativeNumbers {
    @Test
    public void cyclicalFigurativeNumbers() {
        FigurativeNumbers triangles = createFigurativeNumbers(new Triangle());
        FigurativeNumbers squares = createFigurativeNumbers(new Square());
        FigurativeNumbers pentagonals = createFigurativeNumbers(new Pentagonal());
        FigurativeNumbers hexagonals = createFigurativeNumbers(new Hexagonal());
        FigurativeNumbers heptagonals = createFigurativeNumbers(new Heptagonal());
        FigurativeNumbers octogonals = createFigurativeNumbers(new Octagonal());

        FigurativeNumbersList figurativeNumbersList = new FigurativeNumbersList(
                triangles, squares, pentagonals, hexagonals, heptagonals, octogonals);

        Finder finder = new Finder(figurativeNumbersList);

        finder.find();
    }
}
