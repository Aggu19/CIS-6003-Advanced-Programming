package com.cab.model;

public class Car {
    private int carId;
    private String carModel;
    private String licensePlate;
    private String vehicleType;

    // Constructors
    public Car() {}

    public Car(int carId, String carModel, String licensePlate, String vehicleType) {
        this.carId = carId;
        this.carModel = carModel;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    // Getters and Setters
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
