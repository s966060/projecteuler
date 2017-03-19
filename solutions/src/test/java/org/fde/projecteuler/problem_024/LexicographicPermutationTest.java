package org.fde.projecteuler.problem_024;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.iterator.OrderedPermutationIterator;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.fde.util.permutations.Permutation.createPermutation;
import static org.fde.util.permutations.iterator.OrderedPermutationIterator.createOrderedPermutationIterator;
import static org.junit.Assert.assertEquals;

public class LexicographicPermutationTest {
    @Test
    public void theValueOfTheOneMillionthPermutation() {
        ListOfLong input = createListOfLong(0L, 1L, 2, 3, 4, 5, 6, 7, 8, 9);
        OrderedPermutationIterator iterator = createOrderedPermutationIterator(input);

        Permutation actual = null;

        int targetIndex = 999_999;
        int index = 0;

        while (iterator.hasNext() && index <= targetIndex) {
            actual = iterator.next();
            ++index;
        }

        Permutation expected = createPermutation(2, 7, 8, 3, 9, 1, 5, 4, 6, 0);
        assertEquals(expected, actual);
    }
}
