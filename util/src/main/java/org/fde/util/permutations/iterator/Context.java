package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;

class Context {
    private final ListOfLong numbers;
    private final int index;
    private final Context next;

    Context(ListOfLong numbers) {
        this.numbers = numbers;
        this.index = 0;
        this.next = createNextContext(this.numbers, this.index);
    }

    private Context createNextContext(ListOfLong numbers, int takenIndex) {
        if (numbers.size() <= 1) {
            return null;
        } else {
            ListOfLong nextNumbers = new ListOfLong();

            for (int newIndex = 0; newIndex < numbers.size(); ++newIndex) {
                if (newIndex != takenIndex) {
                    Long value = numbers.get(newIndex);
                    nextNumbers.add(value);
                }
            }

            return new Context(nextNumbers);
        }
    }
}
