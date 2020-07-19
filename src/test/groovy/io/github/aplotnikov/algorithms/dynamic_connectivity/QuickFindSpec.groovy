package io.github.aplotnikov.algorithms.dynamic_connectivity

import spock.lang.Specification
import spock.lang.Subject

class QuickFindSpec extends Specification {

    @Subject
    QuickFind algorithm = new QuickFind(10)

    void 'should find unite nodes and find connectivity'() {
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
             * 0 1-2 3-4
             *       | |
             * 5-6 7 8 9
             */
        then:
            with(algorithm) {
                connected(8, 9)
                !connected(5, 0)
            }
        when:
            algorithm.with {
                union(5, 0)
                union(7, 2)
                union(6, 1)
            }
            /*
             * Graph after the operations
             * 0 1-2 3-4
             * | | | | |
             * 5-6 7 8 9
             */
        then:
            with(algorithm) {
                connected(5, 0)
                !connected(7, 3)
            }
    }
}
