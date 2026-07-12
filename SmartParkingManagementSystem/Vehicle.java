package Parking_System;

public abstract class Vehicle {
	private String vehicleNumber;
//	private String vehicleType;
//	private long entryTime;
//	private long exitTime;
//	private int numberOfDoors;
//	private boolean helmetStored;
//	private boolean chargingRequired;

	
//	public boolean isChargingRequired() {
//		return chargingRequired;
//	}
//
//
//	public void setChargingRequired(boolean chargingRequired) {
//		this.chargingRequired = chargingRequired;
//	}
	
	public String isHelmetStored() {
		return "";
	}

	public void setHelmetStored(String helmetStored) {

	}


	public boolean checksVehicleNumber(String vehicleNumber) { 
		String format = "(?i)^[A-Z]{2}[ -]?[0-9]{2}[ -]?[A-Z]{1,2}[ -]?[0-9]{4}$";  
	    return vehicleNumber != null && vehicleNumber.matches(format); 
	}
	

	
	void parkVehicle() {
		
	}
	
	void exitVehicle() {
		
	}
	
	void calculateParkingFee() {
		
	}
	
	void displayVehicle() {
		
	}
	
	public void setvehicleNumber(String vehicleNumber) {
		this.vehicleNumber=vehicleNumber;
	}
	
	public String getvehicleNumber() {
		return vehicleNumber;
	}
	public void setnumberOfDoors(int numberOfDoors) {
		
	}
	
	public int getnumberOfDoors() {
		return 0;
	}
	
	public String getFuelType() {
		return "";
	}

	public void setFuelType(String fuelType) {
		
	}
	
	
//	public void setvehicleType(String vehicleType) {
//		this.vehicleType=vehicleType;
//	}
//	
//	public String getvehicleType() {
//		return vehicleType;
//	}
//	
//	public void setentryTime(long entryTime) {
//		this.entryTime=entryTime;
//	}
//	
//	public long setentryTime() {
//		return entryTime;
//	}
//	
//	public void setexitTime(long exitTime) {
//		this.exitTime=exitTime;
//	}
//	
//	public long getexitTime() {
//		return exitTime;
//	}
//	

	
	Vehicle(){
		
	}


	}


//}
