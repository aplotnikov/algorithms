package io.github.aplotnikov.algorithms.binary_search;

class BinarySearchRecursion {

    private final int[] array;

    BinarySearchRecursion(int... array) {
        this.array = array;
    }

    int search(int elementToFind) {
        return search(elementToFind, 0, array.length - 1);
    }

    private int search(int elementToFind, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            return -1;
        }

        int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
        int middleElement = array[middleIndex];

        if (elementToFind < middleElement) {
            return search(elementToFind, fromIndex, middleIndex - 1);
        }

        if (elementToFind > middleElement) {
            return search(elementToFind, middleIndex + 1, toIndex);
        }

        return middleIndex;
    }
}
