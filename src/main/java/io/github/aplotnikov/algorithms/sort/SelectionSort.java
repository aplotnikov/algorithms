package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is 1/2 * n^2
 */
class SelectionSort extends SortAlgorithm {

    SelectionSort(int... array) {
        super(array);
    }

    void sort() {
        range(0, array.length - 1).forEach(
            currentElementIndex -> {
                int smallestElementIndex = findIndexOfSmallestElement(array, currentElementIndex);
                swap(array, currentElementIndex, smallestElementIndex);
            }
        );
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
