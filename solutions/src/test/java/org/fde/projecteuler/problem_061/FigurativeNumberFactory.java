package org.fde.projecteuler.problem_061;

public class FigurativeNumberFactory {
    FigurativeNumber createFigurativeNumber(int size) {
        switch(size) {
            case 3:
                return new Triangle();
            case 4:
                return new Square();
            case 5:
                return new Pentagonal();
            case 6:
                return new Hexagonal();
            case 7:
                return new Heptagonal();
            case 8:
                return new Octagonal();
            default:
                throw new IllegalArgumentException("size (" + size + ")");
        }
    }
}
