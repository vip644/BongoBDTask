package designpattern.plane;

import designpattern.interfaces.Vehicle;

public class Vistara implements Vehicle {

    @Override
    public int setNumberOfWheels() {
        return 6;
    }

    @Override
    public int setNumberOfPassangers() {
        return 100;
    }

    @Override
    public boolean hasGas() {
        return false;
    }
}
