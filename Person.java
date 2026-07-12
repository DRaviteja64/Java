package Parking_System;

public class Person {

 
//    private String vehicleNumber;
//    private String address;
	private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private MonthlyPass mp;
    private Vehicle vehicle;
    private Payment payment;
    private String type;
    public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
	}
    
    void setResident(String flatNo,String blockName,MonthlyPass monthlyPass){
		
	}
    
	void setVisitor(String visitingFlat,Payment payment){
		
	}
	public String getvisitingFlat() {
		return "";
	}

	public void setvisitingFlat(String purpose) {
	}
    public Person() {

    }

    public Person(int id, String name, int age, String vehicleNumber,
                  String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
//        this.vehicleNumber = vehicleNumber;
//        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getVehicleNumber() {
//        return vehicleNumber;
//    }
//
//    public void setVehicleNumber(String vehicleNumber) {
//        this.vehicleNumber = vehicleNumber;
//    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public MonthlyPass getMonthlyPass() {
		return mp;
	}
    
    public String getFlatNo() {
		return "";
	}
	public void setFlatNo(String flatNo) {
	}

	public void setMonthlyPass(MonthlyPass monthlyPass) {
		
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}