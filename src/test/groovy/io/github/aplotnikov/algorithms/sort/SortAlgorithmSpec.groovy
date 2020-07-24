package io.github.aplotnikov.algorithms.sort

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SortAlgorithmSpec extends Specification {

    @Shared
    int[] unsortedArray = [8, 5, 4, 7, 1]

    void 'should sort provided array by sort algorithm #sortAlgorithm'() {
        when:
            sortAlgorithm.sort()
        then:
            sortAlgorithm.array == [1, 4, 5, 7, 8] as int[]
        where:
            sortAlgorithm << [
                new SelectionSort(unsortedArray),
                new InsertionSort(unsortedArray),
                new ShellSort(unsortedArray),
                new BubbleSort(unsortedArray),
                new MergeSort(unsortedArray),
                new QuickSort(unsortedArray)
            ]
    }
}
