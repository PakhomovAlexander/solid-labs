package impl;

import core.Car;
import org.springframework.stereotype.Service;

@Service
public class CarImpl implements Car {
    public final String name;
    public final double capacity;
    public double mileage;

    double gas;

    public CarImpl(String name, double capacity, double mileage) {
        this.name = name;
        this.capacity = capacity;
        this.mileage = mileage;
    }

    public CarImpl() {
        this("Unknown car", 40, 10);
    }

    @Override
    public void go2Point(int km) {
        double gas2Point = (km / 100.0) * mileage;

        if (gas2Point > gas)
            throw new IllegalStateException("I need more gas to get such long way!");

        gas -= gas2Point;
    }

    @Override
    public void fill(double gas) {
        if (gas < 0)
            throw new IllegalArgumentException("gas < 0");

        if (gas > capacity)
            throw new IllegalArgumentException("I can't get so much gas!");

        this.gas += gas;
    }

    public double getGas() {
        return gas;
    }
}
