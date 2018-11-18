import impl.Car;

public class TaxiDriver {
    private Car car;

    public TaxiDriver(){
        car = new Car("Nissan", 100, 10);
    }

    public void handleOrder(int km) {
        car.fill(100);
        car.go2Point(km);
    }
}
