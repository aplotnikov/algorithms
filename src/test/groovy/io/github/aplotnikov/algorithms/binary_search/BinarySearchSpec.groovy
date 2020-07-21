package io.github.aplotnikov.algorithms.binary_search

import spock.lang.Specification
import spock.lang.Subject

class BinarySearchSpec extends Specification {

    @Subject
    BinarySearch algorithm = new BinarySearch(1, 4, 7, 10, 14, 20, 29, 34)

    void 'should search for element'() {
        expect:
            algorithm.search(elementToFind) == expectedResult
        where:
            elementToFind || expectedResult
            0             || -1
            1             || 0
            2             || -1
            15            || -1
            20            || 5
            33            || -1
            34            || 7
            40            || -1
    }
}
