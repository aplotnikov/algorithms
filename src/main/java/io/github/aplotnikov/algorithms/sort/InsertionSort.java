package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is 1/4 * n^2
 */
class InsertionSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        range(1, result.length).forEach(
            lastElementIndex ->
                range(0, result.length - lastElementIndex).forEach(
                    currentElementIndex -> {
                        if (result[currentElementIndex] <= result[currentElementIndex + 1]) {
                            return;
                        }

                        swap(result, currentElementIndex, currentElementIndex + 1);
                    }
                )
        );

        return result;
    }
}
