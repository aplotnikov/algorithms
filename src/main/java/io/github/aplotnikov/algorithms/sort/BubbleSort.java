package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

/**
 * Complexity is n^2
 */
class BubbleSort extends SortAlgorithm {

    BubbleSort(int... array) {
        super(array);
    }

    @Override
    void sort() {
        range(1, array.length).forEach(
            iteration ->
                range(0, array.length - iteration).forEach(
                    currentElementIndex -> {
                        if (array[currentElementIndex] > array[currentElementIndex + 1]) {
                            swap(array, currentElementIndex, currentElementIndex + 1);
                        }
                    }
                )
        );
    }
}
