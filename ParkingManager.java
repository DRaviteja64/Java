package Parking_System;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class ParkingManager implements ParkingOperations{
	
	static Scanner sc=new Scanner(System.in);
	
	ParkingSlot Parking[]=new ParkingSlot[100];
	static HashMap<String, ParkingSlot> vehicleMap = new HashMap<>();
	static HashMap<String, Person> person=new HashMap<>();
	static HashMap<String, Vehicle> vehicle=new HashMap<>();
	
	static HashMap<Integer,Double>Visitor_amount=new HashMap<>();
	static HashMap<String,Double>Monthly_amount=new HashMap<>();
	static int Vcount=0;
	static int Mcount=0;
	static int PassIdMP=10001;
	static int paymentId=100000;
	static int personId=101;
	static int pscount=0;
	static ParkingManager Pm=new ParkingManager();
	
	static double totalPassRevenue = 0;
	static double totalVisitorRevenue = 0;
	
	
	public void Show() {
		
		do {
			System.out.println("┌───────────────────────────────────────────────┐");
			System.out.println("│                 SMART PARKING                 │");
			System.out.println("├───────────────────────────────────────────────┤");
			System.out.println("│  1. Park Vehicle                              │");
			System.out.println("│  2. Exit Vehicle                              │");
			System.out.println("│  3. Search Vehicle                            │");
			System.out.println("│  4. Register Resident/Visitor                 │");
			System.out.println("│  5. Issues with Pass	                        │");
			System.out.println("│  6. Revenue Report                            │");
			System.out.println("│  7. Show all Parking slots                    │");
			System.out.println("|  8. Print user details                        |");
			System.out.println("│  9. Exit                                      │");
			System.out.println("└───────────────────────────────────────────────┘");
			System.out.print("👉 Enter your choice: ");
			
			int choice = sc.nextInt();

			switch (choice) {
			    case 1 ->{ 
			    	sc.nextLine();
			    	System.out.println("Enter Vehicle number");
			    	String vehicleNum = sc.nextLine().toUpperCase();
			    	Vehicle vehicle1 = vehicle.get(vehicleNum);
			    	Person person1 = person.get(vehicleNum);

			    	if (vehicle1 == null || person1 == null) {
			    	    System.out.println("Vehicle is not registered.");
			    	    System.out.println("Please register Resident/Visitor first.");
			    	    break;
			    	}
			    	ParkingSlot slot = new ParkingSlot();
			    	slot.setVehicle(vehicle1);
			    	slot.setPerson(person1);
			    	slot.setOccupied(true);
			    	slot.setSlotType(person1.getType());
			    	System.out.println("Enter slot number 100 to 199");
			    	int slotNum=sc.nextInt();
			    	if (slotNum < 100 || slotNum > 199) {
			    	    System.out.println("Invalid Slot Number");
			    	    break;
			    	}
			    	if (Parking[slotNum - 100] != null) {
			    	    System.out.println("Slot already occupied.");
			    	    break;
			    	}
			    	if (vehicleMap.containsKey(vehicle1.getvehicleNumber())) {
			    	    System.out.println("Vehicle already parked.");
			    	    break;
			    	}
			    	slot.setSlotNumber(slotNum);
//			    	MonthlyPassMap.put(vehicle1.getvehicleNumber(), slot);
			    	vehicleMap.put(vehicle1.getvehicleNumber(), slot);
			    	Parking[slotNum-100] = slot;
			    }
			    case 2 ->{
			    	System.out.println("Exiting vehicle");
			    	exitVehicle();
			    }
			    case 3 -> {
			    	System.out.println("Search vehicle");
			    	searchVehicle();
			    }
			    case 4 ->{
			    	System.out.println("Adding Resident/Visitor data");
			    	Pm.PersonData();
			    }
			    case 5 -> {
			    	System.out.println("Welcome Can i know What are the issues");
			    	issueMonthlyPass();
			    }
			    case 6 ->{
			    	System.out.println("Welcome to Revenue");
			    	viewRevenueReport();
			    }
			    case 7 ->{
			    	ShowAllslots();
			    }
			    case 8 ->{
			    	PrintDetails();
			    }
			    case 9 -> {
			        System.out.println("Thank you for using Smart Parking. Goodbye!");
			        System.exit(0);
			    }
			    default -> System.out.println("❌ Invalid choice! Please enter a number between 1 and 8.");
			}

		}while(true);
		
		
	}
	
	public void viewRevenueReport() {

	    System.out.println("==================================");
	    System.out.println("         REVENUE REPORT");
	    System.out.println("==================================");
	    System.out.println("1. Monthly Pass Revenue");
	    System.out.println("2. Visitor Parking Revenue");
	    System.out.println("3. Total Revenue");
	    System.out.println("==================================");

	    int choice = sc.nextInt();

	    switch(choice) {

	    case 1 -> {

	        System.out.println("-------------------------------");
	        System.out.println("Monthly Pass Revenue");
	        System.out.println("-------------------------------");
	        for (Map.Entry<String, Double> entry : Monthly_amount.entrySet()) {

	            System.out.println("Vehicle Number : " + entry.getKey());
	            System.out.println("Amount         : " + entry.getValue());
	            System.out.println("----------------------------");
	        }
	        System.out.println("Amount : ₹" + totalPassRevenue);
	    }

	    case 2 -> {

	        System.out.println("-------------------------------");
	        System.out.println("Visitor Parking Revenue");
	        System.out.println("-------------------------------");
	        for (Map.Entry<Integer, Double> entry : Visitor_amount.entrySet()) {
	            System.out.println("Visitor " + entry.getKey()
	                    + " : ₹" + entry.getValue());
	        }
	        System.out.println("Amount : ₹" + totalVisitorRevenue);
	    }

	    case 3 -> {

	        System.out.println("-------------------------------");
	        System.out.println("TOTAL REVENUE");
	        System.out.println("-------------------------------");
	        System.out.println("Monthly Pass : ₹" + totalPassRevenue);
	        System.out.println("Visitor Fee  : ₹" + totalVisitorRevenue);
	        System.out.println("-------------------------------");
	        System.out.println("Total        : ₹"
	                + (totalPassRevenue + totalVisitorRevenue));
	    }

	    default -> System.out.println("Invalid Choice");
	    }
	}
	
	
	public void exitVehicle() {
	    sc.nextLine();
	    System.out.print("Enter Vehicle Number: ");
	    String vehicleNo = sc.nextLine().toUpperCase();
	    ParkingSlot slot = vehicleMap.get(vehicleNo);
	    if (slot == null) {
	        System.out.println("Vehicle Not Found");
	        return;
	    }
	    Person p = slot.getPerson();
	    if (p instanceof Visitor) {
	        person.remove(vehicleNo);
	        vehicle.remove(vehicleNo);
	        System.out.println("Visitor registration deleted.");
	    }
	    Parking[slot.getSlotNumber() - 100] = null;
	    vehicleMap.remove(vehicleNo);
	    System.out.println("Vehicle Exited Successfully.");
	}
	
	public void PrintDetailsData(Person personDetails){

	    System.out.println("\n======================================================");
	    System.out.println("              SMART PARKING MANAGEMENT");
	    System.out.println("======================================================");

	    System.out.println("                  PERSON DETAILS");
	    System.out.println("------------------------------------------------------");

	    System.out.printf("%-20s : %d\n","Person ID",personDetails.getId());
	    System.out.printf("%-20s : %s\n","Name",personDetails.getName());
	    System.out.printf("%-20s : %d\n","Age",personDetails.getAge());

	    if(personDetails instanceof Resident){

	        System.out.printf("%-20s : Resident\n","User Type");
	        System.out.printf("%-20s : %s\n","Flat Number",personDetails.getFlatNo());

	        if(personDetails.getMonthlyPass()!=null){

	            MonthlyPass pass = personDetails.getMonthlyPass();

	            System.out.println();
	            System.out.println("-------------- MONTHLY PASS DETAILS ----------------");

	            System.out.printf("%-20s : %d\n","Pass ID",pass.getPassId());
	            System.out.printf("%-20s : %s\n","Vehicle Number",pass.getVehicleNumber());
	            System.out.printf("%-20s : %s\n","Plan",pass.getType());
	            System.out.printf("%-20s : %.2f\n","Amount",pass.getAmount());
	            System.out.printf("%-20s : %s\n","Start Date",pass.getStartDate());
	            System.out.printf("%-20s : %s\n","Expiry Date",pass.getExpiryDate());
	            System.out.printf("%-20s : %s\n","Status",pass.getStatus());
	            System.out.printf("%-20s : %s\n","Payment Method",pass.getPaymenttype());

	        }else{

	            System.out.printf("%-20s : Not Issued\n","Monthly Pass");
	        }

	    }
	    else if(personDetails instanceof Visitor){
	        Visitor visitor = (Visitor)personDetails;
	        System.out.printf("%-20s : Visitor\n","User Type");
	        System.out.printf("%-20s : %s\n","Visiting Flat",visitor.getvisitingFlat());
	        if(visitor.getPayment()!=null){
	           Payment pay = visitor.getPayment();
	            System.out.println();
	            System.out.println("---------------- PAYMENT DETAILS -------------------");
	            System.out.printf("%-20s : %d\n","Payment ID",pay.getPaymentId());
	            System.out.printf("%-20s : %.2f\n","Amount",pay.getAmount());
	            System.out.printf("%-20s : %d Hours\n","Hours",pay.getHrs());
	            System.out.printf("%-20s : %s\n","Payment Method",pay.getPaymentMethod());
	            System.out.printf("%-20s : %s\n","Payment Date",pay.getPaymentDate());
	            System.out.printf("%-20s : %s\n","Status",pay.isPaymentStatus());
	        }
	    }
	    System.out.printf("%-20s : XXXXXX%s\n",
	            "Phone Number",
	            personDetails.getPhoneNumber().substring(6));
	    Vehicle vehicle = personDetails.getVehicle();
	    System.out.println();
	    System.out.println("---------------- VEHICLE DETAILS -------------------");
	    System.out.printf("%-20s : %s\n","Vehicle Number",vehicle.getvehicleNumber());
	    if(vehicle instanceof Car){
	        System.out.printf("%-20s : Car\n","Vehicle Type");
	        System.out.printf("%-20s : %d\n","Doors",vehicle.getnumberOfDoors());
	        System.out.printf("%-20s : %s\n","Fuel Type",vehicle.getFuelType());
	    }
	    else if(vehicle instanceof Bike){
	        System.out.printf("%-20s : Bike\n","Vehicle Type");
	        System.out.printf("%-20s : %s\n","Helmet Stored",vehicle.isHelmetStored());
	    }
	    else if(vehicle instanceof ElectricVehicle){

	        System.out.printf("%-20s : Electric Vehicle\n","Vehicle Type");
	        System.out.printf("%-20s : %d\n","Doors",vehicle.getnumberOfDoors());
	    }

	    System.out.println("======================================================");
	}
	
	public void PrintDetails() {

	    sc.nextLine();

	    System.out.print("Enter Vehicle Number : ");
	    String vehicleNo = sc.nextLine().toUpperCase();

	    Person p = person.get(vehicleNo);

	    if(p == null){
	        System.out.println("Vehicle Not Registered.");
	        return;
	    }

	    PrintDetailsData(p);
	}
	
	
	public void issueMonthlyPass() {
		sc.nextLine();
		System.out.print("Enter Vehicle Number: ");
	    String vehicleNo = sc.nextLine().toUpperCase(); 
	    boolean check=true;
	    do {
	    	System.out.println("Choose issue");
	 	    System.out.println("1---->New Pass");
	 	    System.out.println("2---->Cancel pass");
	 	    int issue=sc.nextInt();
	 	    switch(issue) {
	 	    case 1 -> {
	 	        if (person.containsKey(vehicleNo)) {
	 	            Person p = person.get(vehicleNo);
	 	            if (p instanceof Resident) {
	 	                MonthlyPass pass = MonthlyPassData(vehicleNo);
	 	                p.setMonthlyPass(pass);
	 	                totalPassRevenue += pass.getAmount();
	 	                Monthly_amount.put(vehicleNo, pass.getAmount());
	 	                check=false;
	 	                System.out.println("Monthly Pass Issued Successfully.");
	 	            } else {
	 	                System.out.println("Visitors cannot have Monthly Pass.");
	 	            }
	 	        } else {
	 	            System.out.println("Vehicle is not registered.");
	 	        }
	 	    }
	 	    case 2 -> {
	 	       if (person.containsKey(vehicleNo)) {
	 	            Person p = person.get(vehicleNo);
	 	            if (p instanceof Resident) {
	 	                p.setMonthlyPass(null);
	 	                Monthly_amount.remove(vehicleNo);
	 	               check=false;
	 	                System.out.println("Monthly Pass Cancelled.");
	 	            } else {
	 	                System.out.println("Visitors do not have Monthly Pass.");
	 	            }
	 	        } else {
	 	            System.out.println("Vehicle is not registered.");
	 	        }
	 	    }
	 	    }
	 	    
	    }while(check);
	   
	}
	
	public void ShowAllslots() {

	    for (int i = 0; i < Parking.length; i++) {
	        if (Parking[i] != null && Parking[i].isOccupied()) {
	        	 System.out.println("------------------------------");
	            System.out.println("Slot No      : " + Parking[i].getSlotNumber());
	            System.out.println("Slot Type    : " + Parking[i].getSlotType());
	            System.out.println("Vehicle No   : " + Parking[i].getVehicle().getvehicleNumber());
	            System.out.println("Occupied");
	            System.out.println("------------------------------");
	        } else {
	            System.out.println("Slot " + (100 + i) + " : Empty");
	        }
	    }
	}
	
	public void searchVehicle() {

	    System.out.print("Enter Vehicle Number : ");
	    String vehicleNo = sc.next().toUpperCase();
	    if (vehicleMap.containsKey(vehicleNo)) {
	        ParkingSlot slot = vehicleMap.get(vehicleNo);
	        System.out.println();
	        System.out.println("+------------+----------------------+----------------------+------------+------------+");
	        System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-10s |%n",
	                "Slot No", "Owner Name", "Vehicle No", "Type", "Status");
	        System.out.println("+------------+----------------------+----------------------+------------+------------+");
	        System.out.printf("| %-10d | %-20s | %-20s | %-10s | %-10s |%n",
	                slot.getSlotNumber(),
	                slot.getPerson().getName(),
	                slot.getVehicle().getvehicleNumber(),
	                slot.getSlotType(),
	                "Occupied");
	        System.out.println("+------------+----------------------+----------------------+------------+------------+");

	    } else {
	        System.out.println();
	        System.out.println("+------------------------------------------------------------+");
	        System.out.println("|                 VEHICLE NOT FOUND                          |");
	        System.out.println("+------------------------------------------------------------+");
	    }
	}

	
	public Payment PaymentData() {
//		private long paymentId;
//	    private double amount;
//	    private String paymentMethod; 
//	    private String paymentDate;
//	    private boolean paymentStatus;
		Payment py=new Payment();
		System.out.println("AutoFilling Payment Id");
		py.setPaymentId(paymentId);
		System.out.println("Enter how many Hours will you stay");
		int hrs=sc.nextInt();
		py.setHrs(hrs);
		System.out.println("Amount will set based on yours hrs");
		py.setAmount(9.9*hrs);
		Visitor_amount.put(Vcount++, 9.9*hrs);
		totalVisitorRevenue += py.getAmount();
		sc.nextLine();
		System.out.println("Enter todat date ex: 06-04-2004");
		String date=sc.nextLine();
		py.setPaymentDate(date);
		boolean check=true;
		do {
			System.out.println("Choose Paymet Method");
			System.out.println("1----> Cash ");
			System.out.println("2----> Upi ");
			System.out.println("3----> Card ");
			int Type=sc.nextInt();
			switch(Type){
				case 1->{
					py.setPaymentMethod("Cash");
					check=false;
				}
				case 2->{
					py.setPaymentMethod("Upi");
					check=false;
				}
				case 3->{
					py.setPaymentMethod("Card");
					check=false; 
				}
				default ->{
					System.out.println("Invalid");
					System.out.println("Payment Canceling Try Again");
				}
			}
		}while(check);
		
		py.setPaymentStatus("Active");
		paymentId++;
		return py;
	}
	
	public Person PersonData() {
		System.out.println("Welcome Sir");
		boolean check=true;
		Person Per=null;
		do {
			System.out.println("choose are you");
			System.out.println("1---->Resident");
			System.out.println("2---->Visitor");
			
			int choose=sc.nextInt();
			sc.nextLine();
			if(choose==1) {
				Per=new Resident();
				check=false;
//				private int id;
//			    private String name;
//			    private int age;
//			    private String phoneNumber;
//				private String flatNo;
//				private String blockName;
//				private MonthlyPass monthlyPass;
				System.out.println("Auto filling Person Id");
				Per.setId(personId);
				System.out.println("Enter yours name");
				String name=sc.nextLine();
				Per.setName(name);
				System.out.println("Enter yours age");
				int age=sc.nextInt();
				Per.setAge(age);
				boolean check1 = true;
				String num;
				do {
				    System.out.print("Enter Phone Number : ");
				    num = sc.next();

				    if (num.matches("[6-9][0-9]{9}")) {
				        Per.setPhoneNumber(num);
				        check1 = false;
				    } else {
				        System.out.println("Invalid Phone Number. Enter a valid 10-digit mobile number.");
				    }

				} while (check1);
				Per.setPhoneNumber(num);
				System.out.println("enter flat Number");
				String flatNo=sc.next();
				Per.setFlatNo(flatNo);
				Vehicle vehicle = VehiclesData();
				if(vehicle == null){
				    return null;
				}
				Per.setVehicle(vehicle);
				Per.setType("CAR");
				person.put(vehicle.getvehicleNumber(), Per);
				Per.setMonthlyPass(null);
				personId++;
				return Per;
			}else if(choose==2) {
//				private String visitingPerson;
//				private String visitingFlat;
//				private Payment payment;
				check=false;
				Per=new Visitor();
				System.out.println("Auto filling Person Id");
				Per.setId(personId);
				System.out.println("Enter yours name");
				String name=sc.nextLine();
				Per.setName(name);
				System.out.println("Enter yours age");
				int age=sc.nextInt();
				Per.setAge(age);
				System.out.println("Enter Phone Number");
				String num=sc.next();
				Per.setPhoneNumber(num);
				System.out.println("enter visitingFlat Number");
				String flatNo=sc.next();
				Per.setvisitingFlat(flatNo);
				Per.setType("Bike");
				Vehicle vehicle = VehiclesData();
				if(vehicle == null){
				    return null;
				}
				Per.setType("Electric Vehicle");
				Per.setVehicle(vehicle);
				person.put(vehicle.getvehicleNumber(), Per);
				Per.setVisitor(flatNo,Pm.PaymentData());
				personId++;
				return Per;
			}else {
				System.out.println("Invalid input");
			}
		}while(check);
		
		return Per;
	}
	
	public MonthlyPass MonthlyPassData(String Vehicleref) {
		MonthlyPass Mp=new MonthlyPass();
//		private int passId;
//	    private double amount;
//	    private String startDate;
//	    private String expiryDate;
//	    private String Status;
//	    private String type;
		System.out.println("AutoFilled Pass ID....");
		Mp.setPassId(PassIdMP);
		System.out.println("ENTER vehicleNumber....");
		Mp.setVehicleNumber(Vehicleref);
		boolean check=true;
		do {
			System.out.println("Choose Which plan do you want");
			System.out.println("1----> 1 Month     Amount   999");
			System.out.println("2----> 6 Months    Amount   4999");
			System.out.println("3----> 12 Months   Amount   9999");
			int Months=sc.nextInt();
			switch(Months){
				case 1->{
					Mp.setAmount(999);
					Mp.setType("1 Month");
					check=false;
				}
				case 2->{
					Mp.setAmount(4999);
					Mp.setType("6 Months");
					check=false;
				}
				case 3->{
					Mp.setAmount(9999);
					Mp.setType("12 Months");
					check=false;
				}
				default ->{
					System.out.println("Invalid");
					System.out.println("Payment Canceling try again");
				}
			}
		}while(check);
		
		sc.nextLine();
		System.out.println("Enter today date ex:06-04-2004");
		String Today=sc.nextLine();
		Mp.setStartDate(Today);
		System.out.println("Enter Expire date");
		String Expire=sc.nextLine();
		Mp.setExpiryDate(Expire);
		Mp.setStatus("Active");
		boolean check1=true;
		do {
			System.out.println("Choose Paymet Method");
			System.out.println("1----> Cash ");
			System.out.println("2----> Upi ");
			System.out.println("3----> Card ");
			int Type=sc.nextInt();
			switch(Type){
				case 1->{
					Mp.setPaymenttype("Cash");
					check1=false;
				}
				case 2->{
					Mp.setPaymenttype("Upi");
					check1=false;
				}
				case 3->{
					Mp.setPaymenttype("Card");
					check1=false;
				}
				default ->{
					System.out.println("Invalid");
					System.out.println("Payment Canceling Try again");
				}
			}
		}while(check1);
		
		PassIdMP++;
		return Mp;
	}
	
	public Vehicle VehiclesData() {
		boolean check1=true;
		Vehicle V=null;
		do {
			System.out.println("Enter your Vehicle type");
			System.out.println("1---->CAR");
			System.out.println("2---->Bike");
			System.out.println("3---->Electric Vehicle");
			int Vehiclecheck=sc.nextInt();
			sc.nextLine();
			
			switch(Vehiclecheck) {
				case 1->{
//					private String vehicleNumber;
//					private int numberOfDoors;
//					private String fuelType;
					V=new Car();
					check1=false;
					System.out.println("Enter Your vehicle Number");
					String VehilceNum=sc.nextLine().toUpperCase();
					if (vehicle.containsKey(VehilceNum)) {
				        System.out.println("Vehicle already registered.");
				        return null;
				    }
					V.setvehicleNumber(VehilceNum);
					vehicle.put(VehilceNum, V);
					System.out.println("Enter Number Of doors");
					int Doors=sc.nextInt();
					V.setnumberOfDoors(Doors);
					boolean check=true;
					do {
						System.out.println("Enter Vehicle Type ");
						System.out.println("Choose");
						System.out.println("1---->Petrol");
						System.out.println("2---->Diseal");
						int TypeChoose=sc.nextInt();
						switch(TypeChoose){
							case 1->{
								V.setFuelType("Petrol");
								check=false;
							}
							case 2->{
								V.setFuelType("Diseal");
								check=false;
							}
							default ->{
								System.out.println("Invalid try again");
							}
						}
					}while(check);
					return V;
					
				}
				case 2->{
//					private String helmetStored;
//					private String vehicleNumber;
					V=new Bike();
					check1=false;
					System.out.println("Enter Your vehicle Number");
					String VehilceNum=sc.nextLine().toUpperCase();
					if (vehicle.containsKey(VehilceNum)) {
				        System.out.println("Vehicle already registered.");
				        return null;
				    }
					V.setvehicleNumber(VehilceNum);
					vehicle.put(VehilceNum, V);
					System.out.println("Enter HelmetStatus ex: Yes -y/No -n");
					char Status=sc.next().charAt(0);
					if(Status=='Y'|| Status=='y') {
						V.setHelmetStored("Yes i have");
						System.out.println("Thanks..");
					}else {
						V.setHelmetStored("NO");
						System.out.println("Thanks..");
					}
					return V;
				}
				case 3->{
//					private boolean chargingRequired;
//					private double chargingTime;
//					private String vehicleNumber;
					V=new ElectricVehicle();
					check1=false;
					System.out.println("Enter Your vehicle Number");
					String VehilceNum=sc.nextLine().toUpperCase();
					if (vehicle.containsKey(VehilceNum)) {
				        System.out.println("Vehicle already registered.");
				        return null;
				    }
					V.setvehicleNumber(VehilceNum);
					System.out.println("enter Number of doors");
					int doors=sc.nextInt();
					vehicle.put(VehilceNum, V);
					V.setnumberOfDoors(doors);
					return V;

				}
				
			}
		}while(check1);
		
		return V;
	}
	
	public static void main(String[] args) {
		
	}
}
