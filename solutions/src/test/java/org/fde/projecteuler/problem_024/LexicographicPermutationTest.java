package org.fde.projecteuler.problem_024;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.OrderedPermutationFactory;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationList;
import org.junit.Test;

import static org.fde.util.ListOfLong.*;
import static org.fde.util.permutations.Permutation.*;
import static org.junit.Assert.assertEquals;

public class LexicographicPermutationTest {
    @Test
    public void theValueOfTheOneMillionthPermutation() {
        ListOfLong input = createListOfLong(0L, 1L, 2, 3, 4, 5, 6, 7, 8, 9);
        OrderedPermutationFactory factory = new OrderedPermutationFactory(input);
        PermutationList list = factory.getPermutations();

        Permutation actual = list.get(999_999);

        Permutation expected = createPermutation(2, 7, 8, 3, 9, 1, 5, 4, 6, 0);
        assertEquals(expected, actual);
    }
}
