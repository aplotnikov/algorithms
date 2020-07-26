package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is 1/4 * n^2
 */
class InsertionSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        range(1, result.length).forEach(to ->
            range(0, result.length - to).forEach(current -> {
                    if (result[current] <= result[current + 1]) {
                        return;
                    }
                    swap(result, current, current + 1);
                }
            )
        );

        return result;
    }
}
