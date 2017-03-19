package org.fde.util.combinations.factory;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.CombinationList;

public class CombinationFactory {
    private final GenericCombinationFactory<Long> internal;

    public CombinationFactory(ListOfLong elements) {
        this.internal = new GenericCombinationFactory<>(elements.getInternalList());
    }

    public CombinationList getCombinations() {
        return new CombinationList(internal.getCombinations());
    }
}
