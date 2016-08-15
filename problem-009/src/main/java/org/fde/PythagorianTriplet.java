package org.fde;

/**
 * Created by filipdelbaen on 13/08/16.
 */
public class PythagorianTriplet {
    public static void main(String[] args) {
        int equalsCondition = 1000;

        // because x + y + z = 1000
        // and x < y < z
        // 332 + 333 + 334 = 1000
        int xLimit = 332;

        for(int x = 1; x <= xLimit; ++x) {
            // say x = 100
            // then yLimit = (1000 - 100) / 2 = 900 / 2 = 450
            // but x < y < z
            // 100 + 450 + 450 = 1000 is not allowed
            // thus 100 + 449 + 451
            int yLimit = (equalsCondition - x) / 2;
            int yLimitRemainder = (equalsCondition - x) % 2;

            if (yLimitRemainder == 0) {
                --yLimit;
            }

            for(int y = x + 1; y <= yLimit; ++y) {
                int z = 1000 - x - y;

                if (z <= 0) {
                    throw new IllegalArgumentException("z = " + z);
                }

                int sumOfSquares = x * x + y * y;
                int square = z * z;

                if(sumOfSquares == square) {
                    System.out.println("square = " + square);
                    System.out.println("sumOfSquares = " + sumOfSquares);
                    System.out.println("x = " + x);
                    System.out.println("y = " + y);
                    System.out.println("z = " + z);

                    System.out.println("x *y *z = " + x * y * z);
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }
}
