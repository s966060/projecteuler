package org.fde.problem_15.fast_recursive;

import org.apache.commons.lang3.Validate;

public class FindRoutes {
    public long findRoute(Lattice lattice) {
        long result;

        if (lattice.getRows() == 0 || lattice.getColumns() == 0) {
            result = 1;
        } else if (lattice.getRows() == 1 || lattice.getColumns() == 1) {
            result = lattice.getRows() + lattice.getColumns();
        } else if ((lattice.getRows() == 2) && (lattice.getColumns() == 2)) {
            result = 6;
        } else {
            result = findRouteRecursive(lattice);
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
            long subRoute = findRoute(new Lattice(max, i, lattice.getLevel() + 1));
            result += subRoute;
        }

        return result;
    }
}
