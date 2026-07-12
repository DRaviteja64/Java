package Parking_System;

public interface VehicleInterface {
    void setVehicleNumber(String vehicleNumber);
    String getVehicleNumber();
    
    void setVehicleType(String vehicleType);
    String getVehicleType();
    
    boolean isHelmetStored();
    void setHelmetStored(boolean helmetStored);
    
    void setNumberOfDoors(int numberOfDoors);
    int getNumberOfDoors();
    
    String getFuelType();
    void setFuelType(String fuelType);
    
    boolean isChargingRequired();
    void setChargingRequired(boolean chargingRequired);
    
    double getChargingTime();
    void setChargingTime(double chargingTime);
}
