package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is 1/2 * n^2
 */
class SelectionSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        range(0, result.length - 1)
            .forEach(current -> swap(result, current, findSmallestElementIndex(result, current)));

        return result;
    }

    private int findSmallestElementIndex(int[] array, int from) {
        return range(from + 1, array.length)
            .reduce(from, (smallest, current) -> {
                    if (array[current] < array[smallest]) {
                        return current;
                    }
                    return smallest;
                }
            );
    }
}
