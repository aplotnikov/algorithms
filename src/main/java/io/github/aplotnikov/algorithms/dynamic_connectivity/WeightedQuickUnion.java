package io.github.aplotnikov.algorithms.dynamic_connectivity;

import static java.util.stream.IntStream.range;

/**
 * Algorithm name: weighted quick-union
 * Complexity:
 * - initialization: N
 * - union: lg N (include cost of finding roots)
 * - find: lg N
 */
class WeightedQuickUnion {

    private final int[] id;

    WeightedQuickUnion(int size) {
        this.id = range(0, size).toArray();
    }

    private int root(int childIndex) {
        int parentIndex = childIndex;
        while (parentIndex != id[parentIndex]) {
            id[parentIndex] = id[id[parentIndex]];
            parentIndex = id[parentIndex];
        }
        return parentIndex;
    }

    boolean connected(int source, int target) {
        return root(source) == root(target);
    }

    void union(int source, int target) {
        id[root(source)] = root(target);
    }
}
