package io.github.aplotnikov.algorithms.sort;

import static java.util.Arrays.copyOfRange;
import static java.util.stream.IntStream.range;

/**
 * Complexity is n lg n
 */
class MergeSort extends SortAlgorithm {

    MergeSort(int... array) {
        super(array);
    }

    @Override
    void sort() {
        int[] result = sort(array);
        range(0, array.length).forEach(
            element -> array[element] = result[element]
        );
    }

    private int[] sort(int[] subarray) {
        if (subarray.length < 2) {
            return subarray;
        }

        int middle = subarray.length / 2;
        int[] left = sort(copyOfRange(subarray, 0, middle));
        int[] right = sort(copyOfRange(subarray, middle, subarray.length));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int rightIndex = 0;
        int leftIndex = 0;
        int resultIndex = 0;

        while (rightIndex < right.length && leftIndex < left.length) {
            if (right[rightIndex] < left[leftIndex]) {
                result[resultIndex++] = right[rightIndex++];
                continue;
            }

            result[resultIndex++] = left[leftIndex++];
        }

        if (rightIndex < right.length) {
            copy(result, resultIndex, right, rightIndex);
        } else if (leftIndex < left.length) {
            copy(result, resultIndex, left, leftIndex);
        }

        return result;
    }

    private void copy(int[] target, int targetStartIndex, int[] source, int sourceStartIndex) {
        for (int i = targetStartIndex, j = sourceStartIndex; j < source.length; i++, j++) {
            target[i] = source[j];
        }
    }
}