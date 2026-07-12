package Parking_System;

public interface ParkingOperations {

    void Show();

    void searchVehicle();

    void exitVehicle();

    void issueMonthlyPass();

    void viewRevenueReport();

    void ShowAllslots();

    void PrintDetails();

    void PrintDetailsData(Person personDetails);

    Payment PaymentData();

    Person PersonData();

    MonthlyPass MonthlyPassData(String vehicleRef);

    Vehicle VehiclesData();
    
    default void Print() {

        System.out.println("==============================================================");
        System.out.println("          WELCOME TO SMART PARKING MANAGEMENT SYSTEM");
        System.out.println("==============================================================");
        System.out.println("This application helps manage parking operations efficiently.");
        System.out.println();
        System.out.println("Features:");
        System.out.println("• Register Residents and Visitors");
        System.out.println("• Register Different Vehicle Types");
        System.out.println("• Allocate Parking Slots");
        System.out.println("• Search Parked Vehicles");
        System.out.println("• Exit Vehicle Management");
        System.out.println("• Monthly Pass Management");
        System.out.println("• Revenue Report Generation");
        System.out.println("• View Parking Slot Status");
        System.out.println("• Print Resident / Visitor Details");
        System.out.println("==============================================================");
        System.out.println("Developed using Java and Object-Oriented Programming Concepts");
        System.out.println("==============================================================");
        System.out.println();
    }
}