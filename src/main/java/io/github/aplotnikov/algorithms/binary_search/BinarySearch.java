package io.github.aplotnikov.algorithms.binary_search;

class BinarySearch {

    private final int[] array;

    BinarySearch(int... array) {
        this.array = array;
    }

    int search(int elementToFind) {
        int fromIndex = 0;
        int toIndex = array.length - 1;

        while (fromIndex <= toIndex) {
            int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
            int middleElement = array[middleIndex];

            if (elementToFind < middleElement) {
                toIndex = middleIndex - 1;
            } else if (elementToFind > middleElement) {
                fromIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }

}
