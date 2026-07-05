package Loan;

import java.util.Scanner;

public class GoldLoan extends Loan {
    double GM;
    double total_amount;
    double Intrest; 
    double GM_Price = 10000;
    double ROI;
    static Scanner sc=new Scanner(System.in);

    @Override
    public void SalaryInfo() {
       
    }
    
    @Override
    public void CalculateValues(double ROI) {
        total_amount = GM * GM_Price;
        Intrest= ((total_amount * ROI) / 100) / 12;
    }

    public void Grams() {
        System.out.println("Enter how many GM of gold:");
        GM = sc.nextDouble();
    }

    @Override
    public void Salary_data() {
        System.out.println("As per Gold price, Loan GM price is: " + GM_Price);
        System.out.println("Based on your gold, maximum eligible loan will be: " + (GM * GM_Price));
        Loan_amount(0, (int)(GM * GM_Price));
    }

    @Override
    public void Loan_amount(int a, int b) {
        ROI = this.calculateRateOfInterest();
        System.out.println("Based on your CIBIL Score, ROI is: " + ROI + "%");
     
    }

    public void GramsChecker() {
        boolean check = true;
        System.out.println("Min grams: 10g and Max grams: 10000g");
        System.out.println("=====================================");
        
        do {
            this.Grams(); 
            if (GM >= 10 && GM <= 10000) {
                System.out.println("Valid amount. Calculating values...");
                check = false;
            } else {
                System.out.println("Entered data is invalid. Please try again.");
            }
        } while (check);
        
         
    }
    
//    public void Print_Details(String Name, int age, double ROI, String Address_details) {
//        System.out.println("\n============================================");
//        System.out.println("          LOAN APPLICATION SUMMARY          ");
//        System.out.println("============================================");
//        System.out.println("Loan Type          : Gold Loan");
//        System.out.println("Applicant Name     : " + Name);
//        System.out.println("Age                : " + age + " years");
//        System.out.println("Mobile Number      : " + "XXXXXX" + getMobile_No().substring(6, 10));
//        System.out.println("Aadhaar Number     : " + "XXXXXXXX" + getAadhar_no().substring(8, 12));
//        System.out.println("CIBIL Score        : " + getCibil_Score());
//        System.out.println("Total GM Of Gold   : " + GM + "g");
//        System.out.println("Per GM(Loan Price) : " + GM_Price + "/-");
//        System.out.println("Assigned ROI       : " + ROI + "%");
//        System.out.println("Total Loan Amount  : " + total_amount + "/-");
////        System.out.println("Loan amount  		:"+getAmount()+ "/-");
////        System.out.println("MONTHLY Interest    : " + Intrest + "/-");
////        System.out.println("ANUAL Interest    : " + Intrest*12 + "/-");
//        System.out.println("Address Details    : " + Address_details);
//        System.out.println("============================================");
//    }
    public void Print_Details(String Name, int age, double ROI, String Address_details) {

        System.out.println("\n======================================================");
        System.out.println("               LOAN APPLICATION SUMMARY");
        System.out.println("======================================================");

        System.out.printf("%-22s : %s%n", "Loan Type", "Gold Loan");
        System.out.printf("%-22s : %s%n", "Applicant Name", Name);
        System.out.printf("%-22s : %d years%n", "Age", age);
        System.out.printf("%-22s : XXXXXX%s%n", "Mobile Number", getMobile_No().substring(6, 10));
        System.out.printf("%-22s : XXXXXXXX%s%n", "Aadhaar Number", getAadhar_no().substring(8, 12));
        System.out.printf("%-22s : %.0f%n", "CIBIL Score", getCibil_Score());
        System.out.printf("%-22s : %.2f g%n", "Total Gold Weight", GM);
        System.out.printf("%-22s : ₹%.2f/-%n", "Per Gram Value", GM_Price);
        System.out.printf("%-22s : %.2f%%%n", "Assigned ROI", ROI);
        System.out.printf("%-22s : ₹%.2f/-%n", "Total Loan Amount", total_amount);
//        System.out.printf("%-22s : ₹%.2f/-%n", "Monthly Interest", Intrest);
//        System.out.printf("%-22s : ₹%.2f/-%n", "Annual Interest", Intrest * 12);
        System.out.printf("%-22s : %s%n", "Address Details", Address_details);

        System.out.println("======================================================");
    }
}