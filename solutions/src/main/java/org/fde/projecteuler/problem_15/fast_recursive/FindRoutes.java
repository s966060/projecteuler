package org.fde.projecteuler.problem_15.fast_recursive;

import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

public class FindRoutes {
    private final Map<Lattice, Long> cachedResults;

    public FindRoutes() {
        this.cachedResults = new HashMap<>();
    }

    public long findRoute(Lattice lattice) {
        long result;

        if (lattice.getRows() == 0 || lattice.getColumns() == 0) {
            result = 1;
        } else if (lattice.getRows() == 1 || lattice.getColumns() == 1) {
            result = lattice.getRows() + lattice.getColumns();
        } else if ((lattice.getRows() == 2) && (lattice.getColumns() == 2)) {
            result = 6;
        } else if (cachedResults.containsKey(lattice)) {
            result = cachedResults.get(lattice);
        } else {
            result = findRouteRecursive(lattice);
            cachedResults.put(lattice, result);
        }

        Validate.isTrue(result == lattice.getRoutes());
        return result;
    }

    private long findRouteRecursive(Lattice lattice) {
        long result;
        int max = Math.max(lattice.getRows(), lattice.getColumns()) - 1;
        int min = Math.min(lattice.getRows(), lattice.getColumns());

        result = 0;

        for (int i = 0; i <= min; ++i) {
            long subRoute = findRoute(new Lattice(max, i));
            result += subRoute;
        }

        return result;
    }
}
