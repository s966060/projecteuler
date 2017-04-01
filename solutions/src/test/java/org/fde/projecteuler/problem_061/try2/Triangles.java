package org.fde.projecteuler.problem_061.try2;

public class Triangles {
    private final PrefixContainer prefix;
    private final PostfixContainer postfix;

    private Triangles(PrefixContainer prefix, PostfixContainer postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public static Triangles createTriangles() {
        PrefixContainer prefix = new PrefixContainer();
        PostfixContainer postfix = new PostfixContainer();

        return new Triangles(prefix, postfix);
    }
}
