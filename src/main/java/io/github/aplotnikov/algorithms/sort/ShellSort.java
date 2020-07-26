package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

/**
 * The complexity is n^3/2
 */
class ShellSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        iterate(
            initialStep(result.length),
            step -> step > 0,
            step -> (step - 1) / 3
        ).forEach(step ->
            range(0, result.length - step)
                .forEach(to -> sort(to, step, result))
        );

        return result;
    }

    private int initialStep(int arraySize) {
        int size = 1;

        while (size <= arraySize / 3) {
            size = size * 3 + 1;
        }

        return size;
    }

    private void sort(int to, int step, int[] array) {
        rangeClosed(0, to).forEach(current -> {
                if (array[current] > array[current + step]) {
                    swap(array, current, current + step);
                }
            }
        );
    }
}
