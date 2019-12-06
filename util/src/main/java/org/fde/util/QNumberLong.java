package org.fde.util;

import static org.fde.util.LeastCommonMultiple.lcm;

public class QNumberLong {
    public final long n;
    public final long d;

    public QNumberLong(long numerator, long d) {
        this.n = numerator;
        this.d = d;
    }

    public QNumberLong(long n) {
        this(n, 1);
    }

    public static QNumberLong numberLong(long n, long d) {
        return new QNumberLong(n, d);
    }

    public static QNumberLong numberLong(long n) {
        return new QNumberLong(n, 1);
    }

    public QNumberLong plus(QNumberLong other) {
        long lcm = lcm(this.d, other.d);

        long x = (this.n * (lcm / this.d)) + (other.n * (lcm / other.d));
        return numberLong(x, lcm);
    }

    @Override
    public String toString() {
        return "Number{" +
                "numerator=" + n +
                ", denomitator=" + d +
                '}';
    }

    public static QNumberLong ZERO = numberLong(0);
    public static QNumberLong ONE = numberLong(1);

    public QNumberLong inverse() {
        return numberLong(this.d, this.n);
    }
}
