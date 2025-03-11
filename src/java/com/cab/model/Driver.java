package com.cab.model;

public class Driver {
    private int driverId;
    private String name;
    private String phoneNumber;
    private String vehicleType;

    // Constructors
    public Driver() {}

    public Driver(int driverId, String name, String phoneNumber, String vehicleType) {
        this.driverId = driverId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    // Getters and Setters
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
