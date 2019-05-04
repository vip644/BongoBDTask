package designpattern.car;


import designpattern.interfaces.Car;


public class Ferrari implements Car {

	
	@Override
	public int setNumberOfWheels() {
		return 4;
	}

	
	@Override
	public int setNumberOfPassangers() {
		return 2;
	}

	
	@Override
	public boolean hasGas() {
		return false;
	}

	
	@Override
	public String engineType() {
		return "Petrol";
	}

	@Override
	public String color() {
		return "Red";
	}

}
