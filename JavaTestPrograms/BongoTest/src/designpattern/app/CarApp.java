package designpattern.app;

import designpattern.car.BMW;
import designpattern.car.Ferrari;
import designpattern.interfaces.Car;


public class CarApp {

    enum Type {
        BMW,
        FERRARI
    }

    private static Car getCarInstance(Type type) {
        Car car = null;

        switch (type) {
            case BMW:
                car = new BMW();
                break;
            case FERRARI:
                car = new Ferrari();
                break;
        }

        return car;
    }

    public static void main(String[] args) {
        Car car = CarApp.getCarInstance(Type.FERRARI);

        System.out.println(car.setNumberOfWheels());
        System.out.println(car.setNumberOfPassangers());
        System.out.println(car.hasGas());
        System.out.println(car.engineType());
        System.out.println(car.color());

    }

}
