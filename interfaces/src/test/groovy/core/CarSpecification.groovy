package core

import impl.CarImpl
import impl.ElectroCarImpl
import spock.lang.Shared
import spock.lang.Specification

class CarSpecification extends Specification {
    @Shared static capacity = 100
    @Shared static name = 'BMV'
    @Shared static mileage = 10

    def 'go to Moscow by gas car'() {
        when: 'fill gas'
        car.fill capacity
        and: 'start from Voronezh'
        car.go2Point 600

        then: 'gas is not over'
        car.gas == 40

        where:
        car = new CarImpl(name, capacity, mileage)
    }

    def 'go to Moscow by electro car'() {
        when: 'charge'
        car.charge capacity
        and: 'start from Voronezh'
        car.go2Point 600

        then: 'gas is not over'
        car.getElectricity() == 40

        where:
        car = new ElectroCarImpl(name, capacity, mileage)
    }


    def 'go to St.P by car without filling gas'() {
        when: 'fill gas'
        car.fill capacity

        and: 'start from Voronezh'
        car.go2Point 1100

        then: 'gas is over ('
        thrown IllegalStateException

        where:
        car = new CarImpl(name, capacity, mileage)
    }

    def 'go to St.P by car without charge'() {
        when: 'fill gas'
        car.charge capacity

        and: 'start from Voronezh'
        car.go2Point 1100

        then: 'power is over ('
        thrown IllegalStateException

        where:
        car = new ElectroCarImpl(name, capacity, mileage)
    }

    def 'go to St.P by car with filling gas'() {
        when: 'fill gas'
        car.fill capacity

        and: 'start from Voronezh'
        car.go2Point 500

        and:
        car.fill 50

        and:
        car.go2Point 600

        then: 'gas is not over'
        car.gas == 40

        where:
        car = new CarImpl(name, capacity, mileage)
    }

    def 'go to St.P by car with charge'() {
        when: 'fill gas'
        car.charge capacity

        and: 'start from Voronezh'
        car.go2Point 500

        and:
        car.charge 50

        and:
        car.go2Point 600

        then: 'gas is not over'
        car.getElectricity() == 40

        where:
        car = new ElectroCarImpl(name, capacity, mileage)
    }
}
