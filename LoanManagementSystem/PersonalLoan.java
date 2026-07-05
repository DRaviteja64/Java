package Loan;

public class PersonalLoan extends Loan {

    @Override
    public void Salary_data() {

        if (getSalary() > 75000) {
            System.out.println("PERSONAL Loan range 500000 to 600000");
            Loan_amount(0, 600000);
        }
        else if (getSalary() > 50000 && getSalary() <= 75000) {
            System.out.println("PERSONAL Loan range 300000 to 500000");
            Loan_amount(300000, 500000);
        }
        else if (getSalary() >= 25000 && getSalary() <= 50000) {
            System.out.println("PERSONAL Loan range 200000 to 300000");
            Loan_amount(200000, 300000);
        }
        else if (getSalary() >= 10000 && getSalary() <= 25000) {
            System.out.println("PERSONAL Loan range 10000 to 150000");
            Loan_amount(10000, 150000);
        }
        else {
            System.out.println("PERSONAL LOAN IS NOT FOR YOU");
            return;
        }

        time_Period();
    }
}