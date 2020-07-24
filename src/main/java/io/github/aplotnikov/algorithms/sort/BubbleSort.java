package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is n^2
 */
class BubbleSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        range(1, result.length).forEach(
            iteration ->
                range(0, result.length - iteration).forEach(
                    currentElementIndex -> {
                        if (result[currentElementIndex] > result[currentElementIndex + 1]) {
                            swap(result, currentElementIndex, currentElementIndex + 1);
                        }
                    }
                )
        );

        return result;
    }
}
