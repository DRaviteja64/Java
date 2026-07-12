package Parking_System;

public class Car extends Vehicle{
	
	private int numberOfDoors;
	private String fuelType;
	
	
	void calculateParkingFee() {
		
	}
	
	void displayVehicle() {
		
	}
	
	
	public void setnumberOfDoors(int numberOfDoors) {
		this.numberOfDoors=numberOfDoors;
	}
	
	public int getnumberOfDoors() {
		return numberOfDoors;
	}
	
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
