package io.github.aplotnikov.algorithms.sort;

abstract class SortAlgorithm {

    protected final int[] array;

    SortAlgorithm(int... array) {
        this.array = array.clone();
    }

    final int[] getArray() {
        return array.clone();
    }

    protected final void swap(int[] array, int firstElementIndex, int secondElementIndex) {
        int previousElement = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = previousElement;
    }

    abstract void sort();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
