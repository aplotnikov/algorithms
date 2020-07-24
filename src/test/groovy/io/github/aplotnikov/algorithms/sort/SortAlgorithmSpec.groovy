package io.github.aplotnikov.algorithms.sort

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SortAlgorithmSpec extends Specification {

    void 'should sort provided array by sort algorithm #algorithm'() {
        given:
            int[] unsortedArray = [8, 5, 4, 7, 1]
        and:
            int[] sortedArray = [1, 4, 5, 7, 8]
        expect:
            algorithm.apply(unsortedArray) == sortedArray
        where:
            algorithm << [
                new SelectionSort(),
                new InsertionSort(),
                new ShellSort(),
                new BubbleSort(),
                new MergeSort(),
                new QuickSort()
            ]
    }
}
