package io.github.aplotnikov.algorithms.dynamic_connectivity;

import static java.util.stream.IntStream.range;

/**
 * Algorithm name: quick-union
 * Complexity:
 * - initialization: N
 * - union: N (include cost of finding roots) - worst case scenario
 * - find: N
 */
public class QuickUnion {

    private final int[] id;

    QuickUnion(int size) {
        this.id = range(0, size).toArray();
    }

    private int root(int childIndex) {
        int parentIndex = childIndex;
        while (parentIndex != id[parentIndex]) {
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
