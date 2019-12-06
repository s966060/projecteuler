package org.fde.util;

import java.math.BigInteger;

import static org.fde.util.LeastCommonMultiple.lcm;

public class QNumberBigInteger {
    public final BigInteger n;
    public final BigInteger d;

    public QNumberBigInteger(BigInteger numerator, BigInteger d) {
        this.n = numerator;
        this.d = d;
    }

    public QNumberBigInteger(BigInteger n) {
        this(n, BigInteger.ONE);
    }

    public static QNumberBigInteger numberBigInteger(BigInteger n, BigInteger d) {
        return new QNumberBigInteger(n, d);
    }

    public static QNumberBigInteger numberBigInteger(BigInteger n) {
        return new QNumberBigInteger(n, BigInteger.ONE);
    }

    public QNumberBigInteger plus(QNumberBigInteger other) {
        BigInteger lcm = lcm(this.d, other.d);

        BigInteger x = (this.n.multiply(lcm).divide(this.d)).add((other.n.multiply(lcm).divide(other.d)));
        return numberBigInteger(x, lcm);
    }

    @Override
    public String toString() {
        return "Number{" +
                "numerator=" + n +
                ", denomitator=" + d +
                '}';
    }

    public static QNumberBigInteger ZERO = numberBigInteger(BigInteger.ZERO);
    public static QNumberBigInteger ONE = numberBigInteger(BigInteger.ONE);

    public QNumberBigInteger inverse() {
        return numberBigInteger(this.d, this.n);
    }
}
