package Parking_System;

public class ParkingSlot {
	
	
	private int slotNumber;

	private String slotType;

	private boolean occupied;

	private Vehicle vehicle;
	
	private Person person;
	
//	
	void assignSlot() {
		
	}

	

//	void releaseSlot() {
//		
//	}
//
//	void displaySlot() {
//		
//	}
//
//	void isOccupied() {
//		
//	}
//
//	void setOccupied() {
//		
//	}
//
//	void getVehicle() {
//		
//	}
//
//	void setVehicle() {
//		
//	}
//
//	void getSlotNumber() {
//		
//	}
//
//	void setSlotNumber() {
//		
//	}
//
//	void getSlotType() {
//		
//	}
//
//	void setSlotType() {
//		
//	}
//	
//	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}

}
