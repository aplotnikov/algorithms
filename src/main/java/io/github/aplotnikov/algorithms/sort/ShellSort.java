package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

/**
 * The complexity is n^3/2
 */
class ShellSort extends SortAlgorithm {

    ShellSort(int... array) {
        super(array);
    }

    private int initialStepSize() {
        int size = 1;

        while (size <= array.length / 3) {
            size = size * 3 + 1;
        }

        return size;
    }

    @Override
    void sort() {
        int stepSize = initialStepSize();

        while (stepSize > 0) {
            int currentStepSize = stepSize;

            range(0, array.length - stepSize).forEach(
                lastElementIndex ->
                    rangeClosed(0, lastElementIndex).forEach(
                        currentElementIndex -> {
                            if (array[currentElementIndex] > array[currentElementIndex + currentStepSize]) {
                                swap(array, currentElementIndex, currentElementIndex + currentStepSize);
                            }
                        }
                    )
            );

            stepSize = (stepSize - 1) / 3;
        }
    }
}
