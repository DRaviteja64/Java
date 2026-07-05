package Loan;

public interface InterfaceLoan {

    String UserName();

    int Validate_Age();

    Boolean ValidateAadhar();

    Boolean ValidatePan();

    Boolean ValidateNumber();

    void CibilScore();

    double calculateRateOfInterest();

    void SalaryInfo();

    String GetAddressDetails();

    int amount_check(int amount, int start, int end);

    void Loan_amount(int start, int end);

    void time_Period();

    void CalculateValues(double ROI);

    void Print_Details(String Name, int age, double ROI, String Address_details);

    void Salary_data();

    void GramsChecker();

    void Home_Loan_data();

    void Home_Loan_Eligibility(double score);

    void Home_Loan_Enter();

    boolean check_cibil();

    // Getters and Setters
    String getLoan();
    void setLoan(String loan);

    double getCibil_Score();
    void setCibil_Score(double score);

    double getSalary();
    void setSalary(double salary);

    int getAmount();
    void setAmount(int amount);

    int getTime();
    void setTime(int time);

    double getRepayment();
    void setRepayment(double repayment);

    double getAmount_ROI();
    void setAmount_ROI(double amountROI);

    String getAadhar_no();
    void setAadhar_no(String aadhar);

    String getMobile_No();
    void setMobile_No(String mobile);
}