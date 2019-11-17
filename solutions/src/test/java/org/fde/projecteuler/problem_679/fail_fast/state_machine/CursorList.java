package org.fde.projecteuler.problem_679.fail_fast.state_machine;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

class CursorList<T extends Enum<T>> {
    private List<Cursor> list;

    CursorList(Enum start) {
        this.list = new ArrayList<>();
        this.list.add(new Cursor<T>(start, 0));
    }

    void push(MachineArea.State state, int count) {
        push(new Cursor<>(state, count));
    }

    void push(Cursor cursor) {
        Validate.notNull(cursor);
        this.list.add(cursor);
    }

    void pop() {
        Validate.isTrue(this.list.size() > 1, "don't pop the first state");
        this.list.remove(lastOne());
    }

    Cursor<T> current() {
        return this.list.get(lastOne());
    }

    private int lastOne() {
        return this.list.size() - 1;
    }
}
