package org.fde.util.permutations;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class OrderedPermutationFactoryTest {
    @Test
    public void one_thePermutationsOf() {
        ListOfLong input = createListOfLong(1);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(Permutation.createPermutation(1));

        assertEquals(expected, actual);
    }

    @Test
    public void two_thePermutationsOf() {
        ListOfLong input = createListOfLong(1, 2);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(Permutation.createPermutation(1, 2))
                .add(Permutation.createPermutation(2, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void three_thePermutationsOf() {
        ListOfLong input = createListOfLong(1, 2, 3);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(Permutation.createPermutation(1, 2, 3))
                .add(Permutation.createPermutation(1, 3, 2))
                .add(Permutation.createPermutation(2, 1, 3))
                .add(Permutation.createPermutation(2, 3, 1))
                .add(Permutation.createPermutation(3, 1, 2))
                .add(Permutation.createPermutation(3, 2, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void four_thePermutationsOf() {
        ListOfLong input = createListOfLong(1, 2, 3, 4);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(Permutation.createPermutation(1, 2, 3, 4))
                .add(Permutation.createPermutation(1, 2, 4, 3))
                .add(Permutation.createPermutation(1, 3, 2, 4))
                .add(Permutation.createPermutation(1, 3, 4, 2))
                .add(Permutation.createPermutation(1, 4, 2, 3))
                .add(Permutation.createPermutation(1, 4, 3, 2))

                .add(Permutation.createPermutation(2, 1, 3, 4))
                .add(Permutation.createPermutation(2, 1, 4, 3))
                .add(Permutation.createPermutation(2, 3, 1, 4))
                .add(Permutation.createPermutation(2, 3, 4, 1))
                .add(Permutation.createPermutation(2, 4, 1, 3))
                .add(Permutation.createPermutation(2, 4, 3, 1))

                .add(Permutation.createPermutation(3, 1, 2, 4))
                .add(Permutation.createPermutation(3, 1, 4, 2))
                .add(Permutation.createPermutation(3, 2, 1, 4))
                .add(Permutation.createPermutation(3, 2, 4, 1))
                .add(Permutation.createPermutation(3, 4, 1, 2))
                .add(Permutation.createPermutation(3, 4, 2, 1))

                .add(Permutation.createPermutation(4, 1, 2, 3))
                .add(Permutation.createPermutation(4, 1, 3, 2))
                .add(Permutation.createPermutation(4, 2, 1, 3))
                .add(Permutation.createPermutation(4, 2, 3, 1))
                .add(Permutation.createPermutation(4, 3, 1, 2))
                .add(Permutation.createPermutation(4, 3, 2, 1));

        assertEquals(expected, actual);
    }

    private PermutationList getPermutations(ListOfLong input) {
        return new OrderedPermutationFactory(input).getPermutations();
    }
}
