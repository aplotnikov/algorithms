package io.github.aplotnikov.algorithms.sort;

import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;

class HeapSort extends SortAlgorithm {

    @Override
    public int[] apply(int[] source) {
        int[] result = source.clone();

        buildHeap(result);

        range(0, result.length)
            .forEach(current -> minHeap(result, current, result.length - 1));

        return result;
    }

    private void buildHeap(int[] array) {
        int size = array.length - 1;
        iterate(
            size / 2,
            index -> index > 0,
            index -> index - 1
        ).forEach(index -> minHeap(array, index, size));
    }

    private void minHeap(int[] array, int parentIndex, int lastIndex) {
        int leftChildIndex = 2 * parentIndex;
        int rightChildIndex = leftChildIndex + 1;

        int minIndex = leftChildIndex <= lastIndex && array[leftChildIndex] < array[parentIndex]
            ? leftChildIndex : parentIndex;

        if (rightChildIndex <= lastIndex && array[rightChildIndex] < array[minIndex]) {
            minIndex = rightChildIndex;
        }

        if (minIndex != parentIndex) {
            swap(array, parentIndex, minIndex);
            minHeap(array, minIndex, lastIndex);
        }
    }
}
