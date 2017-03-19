package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ContextList implements Iterable<Context> {
    private final List<Context> list;

    ContextList(ListOfLong numbers) {
        this.list = new ArrayList<>();

        Context firstContext = new Context(numbers, 0);
        create(firstContext);
    }

    void create(Context context) {
        ListOfLong numbers = context.getNumbers();

        if (!numbers.isEmpty()) {
            this.list.add(context);

            ListOfLong nextNumbers = new ListOfLong();

            for (int index = 0; index < numbers.size(); ++index) {
                if(index != context.getIndex()) {
                    Long value = numbers.get(index);
                    nextNumbers.add(value);
                }
            }

            Context nextContext = new Context(nextNumbers, 0);
            create(nextContext);
        }
    }

    @Override
    public Iterator<Context> iterator() {
        return this.list.iterator();
    }

    Context getFirst() {
        return this.list.get(0);
    }

    Context removeLast() {
        int index = getLastIndex();
        Context last = this.list.remove(index);
        return last;
    }

    Context getLast() {
        int index = getLastIndex();
        return this.list.get(index);
    }

    private int getLastIndex() {
        return this.list.size() - 1;
    }
}
