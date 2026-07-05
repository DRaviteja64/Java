package Loan;

public class CarLoan extends Loan{
	
	 public void Salary_data() {
			if (getSalary() > 75000) {
				System.out.println("CAR Loan range 1000000");
				Loan_amount(50000,1000000);
				
			} 
			else if (getSalary() > 50000 && getSalary() <= 75000) {
				System.out.println("CAR Loan range 50000 to 600000");
				Loan_amount(50000,600000);
			} 
			else if (getSalary() >= 25000 && getSalary() <= 50000) {
				System.out.println("CAR Loan range 50000 to 600000");
				Loan_amount(50000,600000);
			} 
			else if(getSalary() >= 10000 && getSalary() <= 25000){
				System.out.println("CAR Loan range 50000 to 300000");
				Loan_amount(50000,300000);
			}else {
				System.out.println("CAR LOAN IS NOT FOR YOU");
			}
			time_Period();
		}
}
