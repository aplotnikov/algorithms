package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is 1/2 * n^2
 */
class SelectionSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        range(0, result.length - 1).forEach(
            currentElementIndex -> {
                int smallestElementIndex = findIndexOfSmallestElement(result, currentElementIndex);
                swap(result, currentElementIndex, smallestElementIndex);
            }
        );

        return result;
    }

    private int findIndexOfSmallestElement(int[] array, int startIndex) {
        return range(startIndex + 1, array.length)
            .reduce(startIndex, (smallestElementIndex, currentElementIndex) -> {
                    if (array[currentElementIndex] < array[smallestElementIndex]) {
                        return currentElementIndex;
                    }

                    return smallestElementIndex;
                }
            );
    }
}
