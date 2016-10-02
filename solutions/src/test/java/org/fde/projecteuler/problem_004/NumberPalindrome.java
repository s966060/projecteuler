package org.fde.projecteuler.problem_004;

import org.fde.util.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberPalindrome {
    @Test
    public void numberPalindrome() {
        List<Palindrome> list = new ArrayList<>();

        for (int i = 999; i >= 100; --i) {
            for (int j = 999; j >= 100; --j) {
                int r = i * j;

                String a = Integer.toString(r);
                String b = new StringBuilder(a).reverse().toString();

                if (a.equals(b)) {
                    list.add(new Palindrome(i, j));
                }
            }
        }

        Collections.sort(list, new Comparator<Palindrome>() {
            @Override
            public int compare(Palindrome o1, Palindrome o2) {
                int compare = Integer.compare(o1.getPalindrome(), o2.getPalindrome());
                return -compare;
            }
        });

        Logger.log("list = " + list);

        assertEquals(906609, list.get(0).getPalindrome());
    }
}
