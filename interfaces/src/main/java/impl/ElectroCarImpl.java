package impl;

import core.CanGo;
import core.Electro;
import core.HasSportMode;

public class ElectroCarImpl implements CanGo, Electro, HasSportMode {
    public final String name;
    public final double capacity;
    public double mileage;

    private double power;

    public ElectroCarImpl(String name, double capacity, double mileage) {
        this.name = name;
        this.capacity = capacity;
        this.mileage = mileage;
    }

    public ElectroCarImpl() {
        this("Unknown car", 40, 10);
    }

    @Override
    public void go2Point(int km) {
        double power2Point = (km / 100.0) * mileage;

        if (power2Point > power)
            throw new IllegalStateException("I need more power to get such long way!");

        power -= power2Point;
    }

    @Override
    public void sportMode() {
        System.out.println("I am on sport mode!!!");
    }

    @Override
    public void charge(double elect) {
        power += elect;
    }

    @Override
    public double getElectricity() {
        return power;
    }
}
