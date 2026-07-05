package Loan;

import java.util.ArrayList;

public class HomeLoan extends Loan{
	
	int select=-1;
		
	char ch;
	
	static ArrayList<Object>List=new ArrayList<>();
	int amount=0;
	double roi=0;
	int months=0;
	int cibil=0;
	int total_amount=0;
	 
	 Object[][] houseLoans = {
             {500000, 8.50, 60, 615000,500},
             {1000000, 8.75, 120, 1525000,550},
             {1500000, 8.90, 180, 2702000,650},
             {2000000, 9.00, 240, 4320000,700},
             {2500000, 9.10, 300, 6600000,750},
             {3000000, 9.20, 360, 9936000,800},
             {4000000, 9.15, 360, 13248000,800},
             {5000000, 9.25, 360, 16650000,850}
     };
	 
	 public void Home_Loan_data() {
		
		List.clear();

		 System.out.printf("%-15s %-15s %-18s %-20s %-10s%n",
			        "Loan Amount", "Interest", "Months", "Repayment", "Cibil");

	        for (int i = 0; i < houseLoans.length; i++) {
	        	
	            System.out.printf("%-15s %-15s %-18s %-20s %-10s%n",
	                    (Integer) houseLoans[i][0],
	                    (Double) houseLoans[i][1],
	                    (Integer) houseLoans[i][2],
	                    (Integer) houseLoans[i][3],
	                    (Integer) houseLoans[i][4]);
	        }
	    
	}
	
	 public void Home_Loan_Eligibility(double score) {
		System.out.println("=============YOU CAN ELIGIBLE FOR===========");
		System.out.printf("%-15s %-15s %-18s %-20s %-10s%n",
		        "Loan Amount", "Interest", "Months", "Repayment", "Cibil");
		for(int i=0;i<houseLoans.length;i++) {
			if((Integer)houseLoans[i][4]<=score){
				List.add(houseLoans[i]);
				 System.out.printf("%-15s %-15s %-18s %-20s %-10s%n",
		                    (Integer) houseLoans[i][0],
		                    (Double) houseLoans[i][1],
		                    (Integer) houseLoans[i][2],
		                    (Integer) houseLoans[i][3],
		                    (Integer) houseLoans[i][4]);
			}
		}
	}
	 public void Salary_data() {
		 System.out.println("Based On Yours Salary Loan You can APPLY UPTO");

	    if (getSalary() >= 150000) {
	        System.out.println("Eligible Loan Range: ₹10,00,00 to ₹50,00,000");
	        Loan_amount(1000000, 5000000);
	       
	    }

	    else if (getSalary() >= 100000) {
	        System.out.println("Eligible Loan Range: ₹10,00,00 to ₹40,00,000");
	        Loan_amount(1000000, 4000000);
	       
	    }

	    else if (getSalary() >= 75000) {
	        System.out.println("Eligible Loan Range: ₹10,00,00 to ₹30,00,000");
	        Loan_amount(1000000, 3000000);
	       
	    }

	    else if (getSalary() >= 50000) {
	        System.out.println("Eligible Loan Range: ₹10,00,00 to ₹20,00,000");
	        Loan_amount(1000000, 2000000);   
	    }

	    else if (getSalary() >= 30000) {
	        System.out.println("Eligible Loan Range: ₹5,00,000 to ₹10,00,000");
	        Loan_amount(500000, 1000000);
	    }

	    else {
	        System.out.println("Sorry! You are not eligible for a Home Loan.");
	    }
	}
	
	
	public double calculateRateOfInterest() {
	    System.out.println("MINIMUM CIBIL REQUIRED FOR LOAN IS: " + cibil);	
	    return roi;
	}

	int val=0;
	public void Home_Loan_Enter() {
	    for (int i = 0; i < List.size(); i++) {
	        Object[] loan = (Object[]) List.get(i);
	        System.out.println("Choose " + (i + 1) + " --> ₹" + loan[0]);
	        val=i;
	    }

	    int choose = sc.nextInt();

	    if (choose >= 1 && choose <= List.size()) {
	        select = choose - 1;

	        amount = (int) houseLoans[select][0];
	        roi = (double) houseLoans[select][1];
	        months = (int) houseLoans[select][2];
	        total_amount = (int) houseLoans[select][3];
	        cibil = (int) houseLoans[select][4];
	        
	        System.out.println("Do you want to change Months click click yes-y/No-n");
            ch = sc.next().charAt(0);
            if(ch=='y' || ch=='Y') {
            	time_Period();
            	months=getTime();
            }
	        
	    } else {
	        System.out.println("Invalid");
	        return;
	    }
	}
	
	public void Print_Details(String Name, int age, double ROI, String Address_details) {

	    System.out.println("\n=========================================================");
	    System.out.println("                LOAN APPLICATION SUMMARY");
	    System.out.println("=========================================================");

	    System.out.printf("%-22s : %s%n", "Loan Type", getLoan());
	    System.out.printf("%-22s : %s%n", "Applicant Name", Name);
	    System.out.printf("%-22s : %d years%n", "Age", age);
	    System.out.printf("%-22s : XXXXXX%s%n", "Mobile Number", getMobile_No().substring(6, 10));
	    System.out.printf("%-22s : XXXXXXXX%s%n", "Aadhaar Number", getAadhar_no().substring(8, 12));
	    System.out.printf("%-22s : %d%n", "CIBIL Score", cibil);
	    System.out.printf("%-22s : ₹%.2f%n", "Monthly Salary", getSalary());
	    System.out.printf("%-22s : %.2f%%%n", "Assigned ROI", roi);
	    System.out.printf("%-22s : %d Months%n", "Time Period", months);
	    System.out.printf("%-22s : ₹%d/-%n", "Loan Amount", getAmount());
	    System.out.printf("%-22s : ₹%.2f/-%n", "Monthly EMI", getAmount_ROI());
	    System.out.printf("%-22s : ₹%.2f/-%n", "Total Interest", (double)(getRepayment() - amount));
	    System.out.printf("%-22s : ₹%.2f/-%n", "Total Repayment", getRepayment());
	    System.out.println(Address_details);

	    System.out.println("=========================================================");
	}
	double amount_ROI;
	 public void CalculateValues(double ROI) {
		    amount_ROI = (double) total_amount / months;
		    setAmount_ROI(amount_ROI);
		    setRepayment(total_amount);
		  
		}
	 
	 public boolean check_cibil() {
		 if(getCibil_Score()>=cibil) {
			 return true;
		 }
		 return false;
	 }
//	public static void main(String[] args) {
//		
//		HomeLoan hl=new HomeLoan();
//		hl.Home_Loan_data();
//		int n=List.size();
//		for(int i=0;i<n;i++) {
//			System.out.println(List.get(i));
//		}
//	}

}
