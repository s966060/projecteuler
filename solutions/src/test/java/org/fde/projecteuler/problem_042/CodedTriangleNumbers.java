package org.fde.projecteuler.problem_042;

import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CodedTriangleNumbers {
    @Test
    public void codedTriangleNumbers() throws Exception {
        InputStream is = ClassUtil.getInputStream(this, "p042_words.txt");

        List<String> words = new ArrayList<>();

        new LineReader(is) {
            @Override
            public void readLine(String line) throws Exception {
                words.add(line.toUpperCase());
            }
        }.readAll();

        System.out.println("words = " + words);
        System.out.println("words.size() = " + words.size());

        int count = 0;

        for (String word : words) {
            long value = getValue(word);

            if (isTriangleNumber(value)) {
                ++count;
                System.out.println(word + " = " + value);
            }
        }

        System.out.println("count = " + count);
        assertEquals(162, count);
    }

    private long getValue(String word) {
        long value = 0;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            value += ((ch - 'A') + 1);
        }

        return value;
    }

    private boolean isTriangleNumber(long value) {
        long triangle = 0;

        for (int n = 1; value > triangle; ++n) {
            triangle = n * (n + 1) / 2;

            if (value == triangle) {
                return true;
            }
        }

        return false;
    }
}
