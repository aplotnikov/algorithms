package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

/**
 * The complexity is n^3/2
 */
class ShellSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        int stepSize = initialStep(result.length);

        while (stepSize > 0) {
            int currentStepSize = stepSize;

            range(0, result.length - stepSize).forEach(
                lastElementIndex ->
                    rangeClosed(0, lastElementIndex).forEach(
                        currentElementIndex -> {
                            if (result[currentElementIndex] > result[currentElementIndex + currentStepSize]) {
                                swap(result, currentElementIndex, currentElementIndex + currentStepSize);
                            }
                        }
                    )
            );

            stepSize = (stepSize - 1) / 3;
        }

        return result;
    }

    private int initialStep(int arraySize) {
        int size = 1;

        while (size <= arraySize / 3) {
            size = size * 3 + 1;
        }

        return size;
    }
}
