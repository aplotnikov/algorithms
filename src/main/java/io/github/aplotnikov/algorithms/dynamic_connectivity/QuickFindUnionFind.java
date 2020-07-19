package io.github.aplotnikov.algorithms.dynamic_connectivity;

import static java.util.stream.IntStream.range;

/**
 * Algorithm name: quick-find
 * Complexity:
 *  initialization: N
 *  union: N
 *  find: 1
 */
class QuickFindUnionFind {

    private final int[] id;

    QuickFindUnionFind(int size) {
        this.id = range(0, size).toArray();
    }

    boolean connected(int source, int target) {
        return id[source] == id[target];
    }

    void union(int source, int target) {
        int sourceId = id[source];
        int targetId = id[target];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == sourceId) {
                id[i] = targetId;
            }
        }
    }
}
