package Parking_System;

public class ParkingEntry {
	
	public static void main(String args[]) {
		
		ParkingSlot Parking[]=new ParkingSlot[100];
		int pscount=0;

		ParkingManager PM=new ParkingManager();
		
		ParkingSlot slot = new ParkingSlot();

	    Vehicle vehicle = PM.VehiclesData();

	    Person person = PM.PersonData();

	    slot.setVehicle(vehicle);

	    slot.setPerson(person);

	    slot.setOccupied(true);
	    
	    slot.setSlotNumber(100 + pscount);

	    Parking[pscount++] = slot;
	}
	
		
	    
}
