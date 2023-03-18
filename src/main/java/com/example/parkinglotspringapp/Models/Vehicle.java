package com.example.parkinglotspringapp.Models;

public class Vehicle extends BaseModel{
    private String regNumber;
    private VehicleType type;

    public Vehicle(String regNumber, VehicleType type) {
        this.type = type;
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
