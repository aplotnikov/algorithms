package io.github.aplotnikov.algorithms.dynamic_connectivity

import spock.lang.Specification
import spock.lang.Subject

class WeightedQuickUnionSpec extends Specification {

    @Subject
    WeightedQuickUnion algorithm = new WeightedQuickUnion(10)

    void 'should unite nodes and find connectivity'() {
        when:
            algorithm.with {
                union(4, 3)
                union(3, 8)
                union(6, 5)
                union(9, 4)
                union(2, 1)
            }
            /*
             * Graph after the operations
             *
             *         0  1  2  3  4  5  6  7  8  9
             * id[] = [0, 2, 2, 4, 4, 6, 6, 7, 4, 4]
             *
             * 0 2 __4_  6 7
             *   | | | | |
             *   1 3 8 9 5
             */
        then:
            with(algorithm) {
                connected(8, 9)
                !connected(5, 4)
            }
        when:
            algorithm.with {
                union(5, 0)
                union(7, 2)
                union(6, 1)
                union(7, 3)
            }
            /*
             * Graph after the operations
             *
             *         0  1  2  3  4  5  6  7  8  9
             * id[] = [6, 2, 6, 4, 6, 6, 6, 2, 4, 4]
             *
             *     ______6_____
             *     |   |   |   |
             *   __4_  0 __2_  5
             *   | | |   |   |
             *   3 8 9   1   7
             */
        then:
            algorithm.connected(5, 4)
    }
}
