package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is 1/4 * n^2
 */
class InsertionSort extends SortAlgorithm {

    InsertionSort(int... array) {
        super(array);
    }

    @Override
    void sort() {
        range(1, array.length).forEach(
            lastElementIndex ->
                range(0, array.length - lastElementIndex).forEach(
                    currentElementIndex -> {
                        if (array[currentElementIndex] <= array[currentElementIndex + 1]) {
                            return;
                        }

                        swap(array, currentElementIndex, currentElementIndex + 1);
                    }
                )
        );
    }
}
