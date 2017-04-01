package org.fde.projecteuler.problem_061.try2;

import org.fde.util.ListOfLong;

public class PrefixContainer extends Container {
    @Override
    long computeKey(long value) {
        long key = value / 100;
        return key;
    }

    ListOfLong getOnPostFixValue(long value) {
        long key = value % 100;
        ListOfLong list = super.get(key);
        return list;
    }
}
