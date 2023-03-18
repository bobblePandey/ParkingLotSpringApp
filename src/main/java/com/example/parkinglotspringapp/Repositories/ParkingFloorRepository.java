package com.example.parkinglotspringapp.Repositories;

import com.example.parkinglotspringapp.Models.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Long> {

    @Override
    <S extends ParkingFloor> S save(S entity);
}
