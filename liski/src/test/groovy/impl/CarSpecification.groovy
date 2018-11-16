package impl

import spock.lang.Shared
import spock.lang.Specification

class CarSpecification extends Specification {
    @Shared static capacity = 100
    @Shared static name = 'BMV'
    @Shared static mileage = 10

    def 'go to Moscow by car'() {
        when: 'fill gas'
        car.fill capacity
        and: 'start from Voronezh'
        car.go2Point 600

        then: 'gas is not over'
        car.gas == 40

        where:
        car << [new Car(name, capacity, mileage), new ElectroCar(name, capacity, mileage)]
    }

    def 'go to St.P by car without filling'() {
        when: 'fill gas'
        car.fill capacity

        and: 'start from Voronezh'
        car.go2Point 1100

        then: 'gas is over ('
        thrown IllegalStateException

        where:
        car << [new Car(name, capacity, mileage), new ElectroCar(name, capacity, mileage)]
    }

    def 'go to St.P by car with filling'() {
        when: 'fill gas'
        car.fill capacity

        and: 'start from Voronezh'
        car.go2Point 500

        and:
        car.fill 50

        and:
        car.go2Point 600

        then: 'gas is over ('
        car.gas == 40

        where:
        car << [new Car(name, capacity, mileage), new ElectroCar(name, capacity, mileage)]
    }
}
