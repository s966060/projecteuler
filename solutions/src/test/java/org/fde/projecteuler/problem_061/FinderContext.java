package org.fde.projecteuler.problem_061;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.List;

class FinderContext {
    static class Node {
        final Long value;
        final FigurativeNumbers figurativeNumbers;

        Node(Long value, FigurativeNumbers figurativeNumbers) {
            this.value = value;
            this.figurativeNumbers = figurativeNumbers;
        }

        @Override
        public String toString() {
            return "Node{" +
                    this.figurativeNumbers.getFigurativeNumber() + "_" +
                    this.value + '}';
        }
    }

    private final List<Node> nodes;

    FinderContext(Long value, FigurativeNumbers figurativeNumbers) {
        this.nodes = new ArrayList<>();
        add(value, figurativeNumbers);
    }

    FinderContext(List<Node> nodes) {
        this.nodes = nodes;
    }

    FinderContext next(Long value, FigurativeNumbers figurativeNumbers) {
        List<Node> nextNodes = new ArrayList<>(this.nodes);

        FinderContext next = new FinderContext(nextNodes);
        next.add(value, figurativeNumbers);

        return next;
    }

    private void add(Long value, FigurativeNumbers figurativeNumbers) {
        Node node = new Node(value, figurativeNumbers);
        this.nodes.add(node);
    }

    long getCurrentValue() {
        return getLastValue();
    }

    private long getLastValue() {
        Node node = getLastNode();

        return node.value;
    }

    private Node getLastNode() {
        int index = this.nodes.size() - 1;
        return this.nodes.get(index);
    }

    private long getFirstValue() {
        Node node = getFirstNode();

        return node.value;
    }

    private Node getFirstNode() {
        int index = 0;
        return this.nodes.get(index);
    }

    ListOfLong getValues() {
        ListOfLong values = new ListOfLong();

        for (Node node : this.nodes) {
            values.add(node.value);
        }

        return values;
    }

    boolean isClosed() {
        long lastValue = getLastValue();
        long firstValue = getFirstValue();

        Node firstNode = getFirstNode();
        boolean isLinked = firstNode.figurativeNumbers.isLinkedOnPostFixValue(
                lastValue, firstValue);

        return isLinked;
    }

    @Override
    public String toString() {
        return "FinderContext{" +
                "nodes=" + nodes +
                '}';
    }
}
