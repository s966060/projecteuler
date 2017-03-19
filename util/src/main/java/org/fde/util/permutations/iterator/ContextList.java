package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class ContextList implements Iterable<Context> {
    private final List<Context> list;
    private Context first;

    ContextList(ListOfLong numbers) {
        this.list = new ArrayList<>();

        create(numbers);
    }

    private void create(ListOfLong numbers) {
        if (!numbers.isEmpty()) {
            this.list.add(new Context(numbers));

            ListOfLong nextNumbers = new ListOfLong();

            for (int index = 1; index < numbers.size(); ++index) {
                Long value = numbers.get(index);
                nextNumbers.add(value);
            }

            create(nextNumbers);
        }
    }

    @Override
    public Iterator<Context> iterator() {
        return this.list.iterator();
    }

    public Context getFirst() {
        return this.list.get(0);
    }
}
