package com.example.parkinglotspringapp.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class ParkingFloor extends BaseModel{

    private int floorNumber;

    @OneToMany
    @MappedCollection
    List<ParkingSlot> slots;

}
