package org.fde.util.spiral_matrix;

import org.fde.util.ListOfLong;

public class SpiralDiagonal {
    ListOfLong compute(int size) {
        ListOfLong list = new ListOfLong();

        int computeSize = size;

        while (size > 0) {
            ListOfLong listOne = computeOne(computeSize);
            list.addAll(listOne);

            computeSize = stepDownSize(computeSize);
        }

        return list;
    }

    private int stepDownSize(int size) {
        if (size == 1) {
            return 0;
        } else if (size == 2) {
            return 1;
        } else if (size == 3) {
            return 2;
        } else {
            return size - 2;
        }
    }

    ListOfLong computeOne(int size) {
        if (size == 1) {
            return ListOfLong.createListOfLong(1);
        } else if(size == 2) {
            return ListOfLong.createListOfLong(1);
        }
        else {
            ListOfLong list = new ListOfLong();

            int value = size * size;

            for (int i = 0; i < 4; ++i) {
                list.add(value);
                value -= (size - 1);
            }

            return list;
        }
    }


}
