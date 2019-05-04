package designpattern.app;

import designpattern.interfaces.Vehicle;
import designpattern.plane.Indigo;
import designpattern.plane.Vistara;

public class PlaneApp {

    private static Vehicle getPlaneInstances(Type type){

        Vehicle vehicle = null;
        switch (type){
            case VISTARA:
                vehicle = new Vistara();
                break;
            case INDIGO:
                vehicle = new Indigo();
                break;
        }
        return vehicle;
    }

    public static void main(String[] args) {

        Vehicle plane = getPlaneInstances(Type.INDIGO);

        System.out.println(plane.setNumberOfWheels());
        System.out.println(plane.setNumberOfPassangers());
        System.out.println(plane.hasGas());
    }
}

enum Type{
    VISTARA,
    INDIGO
}
