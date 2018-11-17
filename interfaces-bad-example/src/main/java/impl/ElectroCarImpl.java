package impl;

public class ElectroCarImpl extends CarImpl {
    public ElectroCarImpl(String name, double capacity, double mileage) {
        super(name,capacity,mileage);
    }

    @Override
    public void go2Point(int km) {
        double elect = getElectrisity();

        double gas2Point = (km / 100.0) * mileage;

        if (gas2Point > elect)
            throw new IllegalStateException("I need more gas to get such long way!");
    }

    private double getElectrisity() {
        double electr = gas / 2;
        gas = 0;

        return electr;
    }
}
