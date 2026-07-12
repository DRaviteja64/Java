package Parking_System;

public class Resident extends Person {
	
	private String flatNo;
	private MonthlyPass monthlyPass;
//	private Payment payment;


//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}

	Resident(){
		
	}
	
	Resident(String flatNo,MonthlyPass monthlyPass){
		this.flatNo=flatNo;
		this.monthlyPass=monthlyPass;
	}
	

	public MonthlyPass getMonthlyPass() {
		return monthlyPass;
	}

	public void setMonthlyPass(MonthlyPass monthlyPass) {
		this.monthlyPass = monthlyPass;
	}
	

	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}


	
	
	void applyMonthlyPass() {
		
	}

	void renewPass() {
		
	}

	void cancelPass() {
		
	}

	void getFlatNumber() {
		
	}

	void setFlatNumber() {
		
	}

	void setMonthlyPass() {
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
