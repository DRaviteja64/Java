package Parking_System;

public class Payment{

    private long paymentId;
    private double amount;
    private String paymentMethod; 
    private String paymentDate;
    private String paymentStatus;
    private int Hrs;

    public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


    public Payment() {

    }

    public Payment(int paymentId, double amount, String paymentMethod,
                   String paymentDate, String paymentStatus) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

	public int getHrs() {
		return Hrs;
	}

	public void setHrs(int hrs) {
		Hrs = hrs;
	}

}