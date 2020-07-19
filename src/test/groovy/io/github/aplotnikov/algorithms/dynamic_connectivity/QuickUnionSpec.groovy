package io.github.aplotnikov.algorithms.dynamic_connectivity

import spock.lang.Specification
import spock.lang.Subject

class QuickUnionSpec extends Specification {

    @Subject
    QuickUnion algorithm = new QuickUnion(10)

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
             * id[] = [0, 1, 1, 8, 3, 5, 5, 7, 8, 8]
             *
             * 0 1 5 7 8_
             *   | |   | |
             *   2 6   3 9
             *         |
             *         4
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
             * id[] = [1, 8, 1, 8, 3, 0, 5, 1, 8, 8]
             *
             *   _____8__
             *   |    |  |
             * __1__  3  9
             * | |  |
             * 0 2  7
             * |
             * 5
             * |
             * 6
             */
        then:
            algorithm.connected(5, 4)
    }
}
