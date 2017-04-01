package org.fde.projecteuler.problem_062;

import java.util.ArrayList;
import java.util.List;

class Nodes {
    private final List<Node> nodes;

    public Nodes() {
        this.nodes = new ArrayList<Node>();
    }

    public void add(Node node) {
        this.nodes.add(node);
    }

    public int size() {
        return this.nodes.size();
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "nodes=" + nodes +
                '}';
    }

    public Node get(int index) {
        return this.nodes.get(index);
    }
}
