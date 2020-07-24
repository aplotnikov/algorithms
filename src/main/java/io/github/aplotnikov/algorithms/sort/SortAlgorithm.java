package io.github.aplotnikov.algorithms.sort;

import java.util.function.UnaryOperator;

abstract class SortAlgorithm implements UnaryOperator<int[]> {

    protected final void swap(int[] array, int firstElementIndex, int secondElementIndex) {
        int previousElement = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = previousElement;
    }

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
