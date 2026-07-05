package Loan;

import java.util.Scanner;

public class MainExecutor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InterfaceLoan L = null;
        char ch;

        do {

            System.out.println("Hello Good Mrng sir");
            System.out.println("enter which type of loan did you want");
            System.out.println("Choose 1 -> Personal Loan");
            System.out.println("Choose 2 -> Car Loan");
            System.out.println("Choose 3 -> Gold Loan");
            System.out.println("Choose 4 -> Home Loan");

            int choice = sc.nextInt();

            if (choice == 1) {
                L = new PersonalLoan();
                L.setLoan("Personal Loan");
            } else if (choice == 2) {
                L = new CarLoan();
                L.setLoan("Car Loan");
            } else if (choice == 3) {
                L = new GoldLoan();
                L.setLoan("Gold Loan");
            } else if (choice == 4) {
                L = new HomeLoan();
                L.setLoan("Home Loan");
            } else {
                System.out.println("Invalid choice.");
                System.out.println("Do you want to re apply ? click yes-y/No-n");
                ch = sc.next().charAt(0);
                continue;
            }

            System.out.println("\nExecuting: " + L.getLoan().toUpperCase());
            System.out.println("Enter yours " + L.getLoan() + " details");

            String Name = L.UserName();
            int Age = L.Validate_Age();

            if (Age >= 18 && Age <= 60) {

                if (L.ValidateAadhar() && L.ValidatePan()) {

                    if (L.ValidateNumber()) {

                        L.CibilScore();
                        if(L.check_cibil()) {
                        	
                            if (L.getCibil_Score() >= 300 && L.getCibil_Score() <= 900) {

                                L.Home_Loan_data();
                                L.Home_Loan_Eligibility(L.getCibil_Score());
                                L.Home_Loan_Enter();

                                double ROI = L.calculateRateOfInterest();

                                if (L.check_cibil()) {

                                    L.GramsChecker();
                                    L.SalaryInfo();
                                    L.Salary_data();
                                    L.CalculateValues(ROI);

                                    String Address_details = L.GetAddressDetails();

                                    L.Print_Details(Name, Age, ROI, Address_details);

                                } else {
                                    System.out.println("INVALID CIBIL SCORE");
                                }

                            } else {
                                System.out.println("INVALID CIBIL SCORE");
                            }

                        }else {
                        	System.out.println("Cibil Score not matched");
                        }


                    } else {
                        System.out.println("ONCE CHECK MOBILE NUMBER");
                    }

                } else {
                    System.out.println("INVALID AADHAR OR PAN");
                }

            } else {
                System.out.println("Your Age is not Matched with our data");
            }

            System.out.println("Do you want to re apply ? click yes-y/No-n");
            ch = sc.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }
}