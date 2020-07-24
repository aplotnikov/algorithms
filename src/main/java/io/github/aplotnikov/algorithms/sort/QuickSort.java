package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.range;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Complexity is n lg n
 */
class QuickSort extends SortAlgorithm {

    private static final Random RANDOM = new SecureRandom();

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        shuffle(result);
        sort(result, 0, result.length - 1);

        return result;
    }

    private void shuffle(int[] array) {
        range(0, array.length).forEach(
            index -> swap(array, index, RANDOM.nextInt(index + 1))
        );
    }

    private void sort(int[] array, int from, int to) {
        if (to <= from) {
            return;
        }

        int index = partition(array, from, to);
        sort(array, from, index - 1);
        sort(array, index + 1, to);
    }

    private int partition(int[] array, int from, int to) {
        int left = from;
        int right = to + 1;

        while (left < right) {
            while (array[++left] < array[from]) {
                if (left == to) {
                    break;
                }
            }

            while (array[from] < array[--right]) {
                if (right == to) {
                    break;
                }
            }

            if (left < right) {
                swap(array, left, right);
            }
        }

        swap(array, from, right);

        return right;
    }
}
