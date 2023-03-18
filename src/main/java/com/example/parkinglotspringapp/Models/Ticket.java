package com.example.parkinglotspringapp.Models;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
public class Ticket extends BaseModel{

    private Date timeStamp;
    private int floorNum;
    @OneToOne
    private ParkingSlot slot;
    @OneToMany
    private List<Payment> paymentList;
    @OneToOne
    private EntryGate entryGate;
    @OneToOne
    private ExitGate exitGate;

    public Ticket(int floorNum, ParkingSlot slot) {
        timeStamp = new Date();
        this.floorNum = floorNum;
        this.slot = slot;
    }

}
