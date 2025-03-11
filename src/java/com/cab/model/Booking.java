package com.cab.model;

import java.util.Date;

public class Booking {
    private int bookingId;
    private int customerId;
    private String pickupLocation;
    private Date bookingDate;
    private String bookingTime;
    private int hourLimit;
    private double totalAmount;

    // Constructors
    public Booking() {}

    public Booking(int bookingId, int customerId, String pickupLocation, Date bookingDate, String bookingTime, int hourLimit, double totalAmount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.hourLimit = hourLimit;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getHourLimit() {
        return hourLimit;
    }

    public void setHourLimit(int hourLimit) {
        this.hourLimit = hourLimit;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
