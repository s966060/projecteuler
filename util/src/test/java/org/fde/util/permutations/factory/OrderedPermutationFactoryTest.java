package org.fde.util.permutations.factory;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.PermutationList;
import org.fde.util.permutations.factory.OrderedPermutationFactory;
import org.junit.Test;

import static org.fde.util.permutations.Permutation.createPermutation;
import static org.junit.Assert.assertEquals;

public class OrderedPermutationFactoryTest {
    @Test
    public void one_thePermutationsOf() {
        PermutationList actual = createActual(1);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1));

        assertEquals(expected, actual);
    }

    @Test
    public void two_thePermutationsOf() {
        PermutationList actual = createActual(1, 2);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2))
                .add(createPermutation(2, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void three_thePermutationsOf() {
        PermutationList actual = createActual(1, 2, 3);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2, 3))
                .add(createPermutation(1, 3, 2))
                .add(createPermutation(2, 1, 3))
                .add(createPermutation(2, 3, 1))
                .add(createPermutation(3, 1, 2))
                .add(createPermutation(3, 2, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void four_thePermutationsOf() {
        PermutationList actual = createActual(1, 2, 3, 4);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2, 3, 4))
                .add(createPermutation(1, 2, 4, 3))
                .add(createPermutation(1, 3, 2, 4))
                .add(createPermutation(1, 3, 4, 2))
                .add(createPermutation(1, 4, 2, 3))
                .add(createPermutation(1, 4, 3, 2))

                .add(createPermutation(2, 1, 3, 4))
                .add(createPermutation(2, 1, 4, 3))
                .add(createPermutation(2, 3, 1, 4))
                .add(createPermutation(2, 3, 4, 1))
                .add(createPermutation(2, 4, 1, 3))
                .add(createPermutation(2, 4, 3, 1))

                .add(createPermutation(3, 1, 2, 4))
                .add(createPermutation(3, 1, 4, 2))
                .add(createPermutation(3, 2, 1, 4))
                .add(createPermutation(3, 2, 4, 1))
                .add(createPermutation(3, 4, 1, 2))
                .add(createPermutation(3, 4, 2, 1))

                .add(createPermutation(4, 1, 2, 3))
                .add(createPermutation(4, 1, 3, 2))
                .add(createPermutation(4, 2, 1, 3))
                .add(createPermutation(4, 2, 3, 1))
                .add(createPermutation(4, 3, 1, 2))
                .add(createPermutation(4, 3, 2, 1));

        assertEquals(expected, actual);
    }

    private PermutationList createActual(long... values) {
        ListOfLong input = new ListOfLong();

        for (long value : values) {
            input.add(value);
        }

        return new OrderedPermutationFactory(input).getPermutations();
    }
}
