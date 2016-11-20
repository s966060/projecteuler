package org.fde.util.combinations;

import org.fde.util.ListOfLong;

public class CombinationFactory {
    private final GenericCombinationFactory<Long> internal;

    public CombinationFactory(ListOfLong elements) {
        this.internal = new GenericCombinationFactory<>(elements.getInternalList());
    }

    public CombinationList getCombinations() {
        return new CombinationList(internal.getCombinations());
    }
}
