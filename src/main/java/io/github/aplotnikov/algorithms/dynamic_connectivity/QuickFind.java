package io.github.aplotnikov.algorithms.dynamic_connectivity;

import static java.util.stream.IntStream.range;

/**
 * Algorithm name: quick-find
 * Complexity:
 * - initialization: N
 * - union: N
 * - find: 1
 */
class QuickFind {

    private final int[] id;

    QuickFind(int size) {
        this.id = range(0, size).toArray();
    }

    boolean connected(int source, int target) {
        return id[source] == id[target];
    }

    void union(int source, int target) {
        int sourceId = id[source];
        int targetId = id[target];
        range(0, id.length)
            .filter(index -> id[index] == sourceId)
            .forEach(index -> id[index] = targetId);
    }
}
