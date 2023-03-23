package edu.java.inheritance03;

public class Car {
	
	// field
	private double fuel;
	private double speed;
	
	// constructor
	public Car(double fuel, double speed) {
		this.fuel = fuel;
		this.speed = speed;
	}
	
	// method
	public double getFuel() {
		return this.fuel;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void drive() {
		System.out.printf("자동차 운전: 속력=%.1f, 연료=%.1f\n", this.speed, this.fuel);
	}

}
