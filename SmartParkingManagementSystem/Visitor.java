package Parking_System;

public class Visitor extends Person{
	
	
	private String visitingFlat;
	private Payment payment;
	
	Visitor(String visitingFlat,Payment payment){
		this.payment=payment;
		this.visitingFlat = visitingFlat;
	}
	
	Visitor(){
		
	}
	
	

	public String getvisitingFlat() {
		return visitingFlat;
	}

	public void setvisitingFlat(String purpose) {
		this.visitingFlat = purpose;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	


	
}
