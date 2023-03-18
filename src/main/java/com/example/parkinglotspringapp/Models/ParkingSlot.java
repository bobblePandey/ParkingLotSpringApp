package com.example.parkinglotspringapp.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ParkingSlot extends BaseModel{

    String slotName;

    VehicleType type;

    ParkingSlotStatus status;
}
