package com.example.parkinglotspringapp.Repositories;

import com.example.parkinglotspringapp.Models.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

    @Override
    List<ParkingLot> findAll();
}
