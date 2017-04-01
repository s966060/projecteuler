package org.fde.projecteuler.problem_062;

import org.fde.util.Digits;

import java.util.HashMap;
import java.util.Map;

class MyMap {

    private final Map<Digits, Nodes> map;

    MyMap() {
        this.map = new HashMap<>();
    }

    private Long target;

    void put(Node node) {
        Nodes values = this.map.computeIfAbsent(
                node.digits, list -> new Nodes());

        values.add(node);

        if (values.size() == 5) {
            System.out.println("values = " + values);

            if (target == null) {
                target = values.get(0).cube;
            }
        }
    }

    Long getTarget() {
        return target;
    }
}
