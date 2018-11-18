import core.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiDriver {
    private Car car;

    @Autowired
    public TaxiDriver(Car car) {
        this.car = car;
    }

    public void handleOrder(int km) {
        car.fill(100);
        car.go2Point(km);
    }
}
