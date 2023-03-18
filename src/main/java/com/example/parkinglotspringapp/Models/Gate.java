package com.example.parkinglotspringapp.Models;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Gate extends BaseModel {

    @OneToOne
    public GateOperator operator;

    @OneToOne
    public DisplayBoard informationDisplayBoard;

}
