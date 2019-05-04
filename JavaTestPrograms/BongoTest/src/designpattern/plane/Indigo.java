package designpattern.plane;

import designpattern.interfaces.Vehicle;

public class Indigo implements Vehicle {

    @Override
    public int setNumberOfWheels() {
        return 6;
    }

    @Override
    public int setNumberOfPassangers() {
        return 200;
    }

    @Override
    public boolean hasGas() {
        return false;
    }
}
