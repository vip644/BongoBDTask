package designpattern.car;


import designpattern.interfaces.Car;

public class BMW implements Car {

	
	@Override
	public int setNumberOfWheels() {
		return 4;
	}

	
	@Override
	public int setNumberOfPassangers() {
		return 4;
	}

	
	@Override
	public boolean hasGas() {
		return false;
	}

	
	@Override
	public String engineType() {
		return "Diesel";
	}

	@Override
	public String color() {
		return "Black";
	}

}
