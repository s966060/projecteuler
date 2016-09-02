package org.fde.problem_013;

import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SumOfNumbersTest {
    @Test
    public void computeTheFirstTenDigits() throws Exception {
        InputStream is = ClassUtil.getInputStream(this, "theNumbers.txt");

        final ReferenceToBigDecimal sum = new ReferenceToBigDecimal(0L);

        new LineReader(is) {
            @Override
            public void readLine(String line) throws Exception {
                BigDecimal number = new BigDecimal(line);

                sum.number = sum.number.add(number);
            }
        }.readAll();

        System.out.println("sum.number = " + sum.number);

        String actual = sum.number.toString();
        assertEquals("5537376230390876637302048746832985971773659831892672", actual);
        assertEquals("5537376230", actual.substring(0, 10));
    }

    class ReferenceToBigDecimal {
        BigDecimal number;

        public ReferenceToBigDecimal(long value) {
            this.number = new BigDecimal(value);
        }
    }
}
