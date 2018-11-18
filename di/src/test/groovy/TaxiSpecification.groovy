import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import spock.lang.Specification

@ContextConfiguration(classes = [AppConfig.class])
//@RunWith(SpringJUnit4ClassRunner)
class TaxiSpecification extends Specification{

    @Autowired
    TaxiDriver taxiDriver //todo: handle a cleanup policy

    def 'get wrong point'() {
        when:
        taxiDriver.handleOrder(1001)

        then:
        thrown IllegalStateException
    }

    def 'get right point'() {
        when:
        taxiDriver.handleOrder(100)

        then: true
    }
}
