package com.example.parkinglotspringapp.Models;

import javax.persistence.Entity;

@Entity
public class GateOperator extends BaseModel{

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
