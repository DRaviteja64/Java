package Loan;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Loan implements InterfaceLoan {
	private double Cibil_Score;
	private double amount_ROI;
	private int amount;
	private int time;
	private double Salary;
	private double Repayment;
	private String Aadhar_no;
	private String Mobile_No;
	private String Loan;
	Scanner sc = new Scanner(System.in);
	// Loan

	public String UserName() {
		System.out.println("enter name");
		String name = sc.nextLine();
		return name;
	}

	public int Validate_Age() {
		System.out.println("enter Age");
		int Age = sc.nextInt();
		sc.nextLine();
		return Age;
	}

	public Boolean ValidateAadhar() {
		System.out.println("Enter 12-digit Aadhaar number:");
		Aadhar_no = sc.next();
		sc.nextLine();
		String AadharRegex = "[2-9][0-9]{11}";
		return Pattern.matches(AadharRegex, Aadhar_no);
	}

	public Boolean ValidatePan() {
		System.out.println("Enter 10-digit Pan number:");
		String PanNum = sc.next();
		sc.nextLine();
		String PanRegex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		return Pattern.matches(PanRegex, PanNum);
	}

	public Boolean ValidateNumber() {
		System.out.println("Enter 10-digit Mobile number:");
		Mobile_No = sc.next();
		String MobRegex = "[6-9]{1}[0-9]{9}";
		return Pattern.matches(MobRegex, Mobile_No);
	}

	public void CibilScore() {
		System.out.println("Enter cibil Score");
		Cibil_Score = sc.nextInt();
	}

	public double calculateRateOfInterest() {
		System.out.println("ROI is based on your CIBIL Score: " + Cibil_Score);
		if (Cibil_Score >= 800 && Cibil_Score <= 900) {
			System.out.println("Excellent score: 7.5% interest");
			return 7.5;
		} else if (Cibil_Score >= 750 && Cibil_Score < 800) {
			System.out.println("Good score: 8.5% interest");
			return 8.5;
		} else if (Cibil_Score >= 700 && Cibil_Score < 750) {
			System.out.println("Fair score: 9.5% interest");
			return 9.5;
		} else if (Cibil_Score >= 650 && Cibil_Score < 700) {
			System.out.println("Average score: 11.5% interest");
			return 11.5;
		} else if (Cibil_Score >= 300 && Cibil_Score < 650) {
			System.out.println("Poor score: High-risk 14.5% interest");
			return 14.5;
		} else {
			System.out.println("Invalid CIBIL Score provided.");
			return 0;
		}
	}

	public void SalaryInfo() {
		System.out.println("Enter Salary");
		Salary = sc.nextDouble();
		sc.nextLine();
	}

	public String GetAddressDetails() {
		System.out.println("--- Enter Applicant Address Details ---");

		System.out.print("Enter Flat/House No. & Building: ");
		String houseDetails = sc.nextLine();
		sc.nextLine();

		System.out.print("Enter Street / Locality: ");
		String street = sc.nextLine();

		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter State: ");
		String state = sc.nextLine();

		System.out.print("Enter 6-digit PIN Code: ");
		int pinCode = sc.nextInt();
		sc.nextLine();

		return ("Address: " + houseDetails + ", " + street + ", " + city + ", " + state + " - " + pinCode);
	}

	public int amount_check(int amount, int start, int end) {
		if (amount >= start && amount <= end) {
			return amount;
		}
		return -1;
	}

	public void Loan_amount(int start, int end) {
		do {
			if (amount == -1) {
				System.out.println("entered amount is invalid re enter again");
			}
			System.out.println("Enter Loan amount");
			int amount1 = sc.nextInt();
			amount = amount_check(amount1, start, end);
		} while (amount == -1);

	}

	public void time_Period() {
		System.out.println("Enter time period");
		time = sc.nextInt();
	}

	public void CalculateValues(double ROI) {
		double timeInYears = time / 12.0;
		amount_ROI = (amount * ROI * timeInYears) / 100;
		Repayment = amount_ROI + amount;
	}

	public void Print_Details(String Name, int age, double ROI, String Address_details) {

	    System.out.println("\n====================================================");
	    System.out.println("               LOAN APPLICATION SUMMARY");
	    System.out.println("====================================================");

	    System.out.printf("%-22s : %s%n", "Loan Type", getLoan());
	    System.out.printf("%-22s : %s%n", "Applicant Name", Name);
	    System.out.printf("%-22s : %d years%n", "Age", age);
	    System.out.printf("%-22s : XXXXXX%s%n", "Mobile Number", getMobile_No().substring(6, 10));
	    System.out.printf("%-22s : XXXXXXXX%s%n", "Aadhaar Number", getAadhar_no().substring(8, 12));
	    System.out.printf("%-22s : %.0f%n", "CIBIL Score", getCibil_Score());
	    System.out.printf("%-22s : ₹%.2f%n", "Monthly Salary", getSalary());
	    System.out.printf("%-22s : %.2f%%%n", "Assigned ROI", ROI);
	    System.out.printf("%-22s : %d Months%n", "Loan Tenure", getTime());
	    System.out.printf("%-22s : ₹%d/-%n", "Loan Amount", getAmount());
	    System.out.printf("%-22s : ₹%.2f/-%n", "Monthly EMI", getRepayment() / getTime());
	    System.out.printf("%-22s : ₹%.2f/-%n", "Total Interest", getAmount_ROI());
	    System.out.printf("%-22s : ₹%.2f/-%n", "Total Repayment", getRepayment());
	    System.out.printf("%-22s : %s%n", "Address", Address_details);

	    System.out.println("====================================================");
	}
	
	public void Salary_data() {
		if (Salary > 75000) {
			System.out.println("Loan range 800000");
			Loan_amount(0, 800000);
		} else if (Salary > 50000 && Salary <= 75000) {
			System.out.println("Loan range 600000 to 800000");
			Loan_amount(600000, 800000);
		} else if (Salary >= 25000 && Salary <= 50000) {
			System.out.println("Loan range 400000 to 550000");
			Loan_amount(400000, 550000);
		} else if (Salary >= 10000 && Salary <= 25000) {
			System.out.println("Loan range 100000 to 200000");
			Loan_amount(100000, 200000);
		} else {
			System.out.println("LOAN IS NOT FOR YOU");
		}
		time_Period();
	}

	public void GramsChecker() {

	}

	public void Home_Loan_data() {

	}

	public void Home_Loan_Eligibility(double score) {

	}

	public void Home_Loan_Enter() {

	}

	public boolean check_cibil() {
		return true;
	}

	// Loan Type
	public String getLoan() {
	    return Loan;
	}

	public void setLoan(String loan) {
	    this.Loan = loan;
	}

	// CIBIL Score
	public double getCibil_Score() {
	    return Cibil_Score;
	}

	public void setCibil_Score(double cibil_Score) {
	    this.Cibil_Score = cibil_Score;
	}

	// Interest Amount
	public double getAmount_ROI() {
	    return amount_ROI;
	}

	public void setAmount_ROI(double amount_ROI) {
	    this.amount_ROI = amount_ROI;
	}

	// Loan Amount
	public int getAmount() {
	    return amount;
	}

	public void setAmount(int amount) {
	    this.amount = amount;
	}

	// Time Period
	public int getTime() {
	    return time;
	}

	public void setTime(int time) {
	    this.time = time;
	}

	// Salary
	public double getSalary() {
	    return Salary;
	}

	public void setSalary(double salary) {
	    this.Salary = salary;
	}

	// Total Repayment
	public double getRepayment() {
	    return Repayment;
	}

	public void setRepayment(double repayment) {
	    this.Repayment = repayment;
	}

	// Aadhaar Number
	public String getAadhar_no() {
	    return Aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
	    this.Aadhar_no = aadhar_no;
	}

	// Mobile Number
	public String getMobile_No() {
	    return Mobile_No;
	}

	public void setMobile_No(String mobile_No) {
	    this.Mobile_No = mobile_No;
	}


}
