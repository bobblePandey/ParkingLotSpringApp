package com.example.parkinglotspringapp.Repositories;

import com.example.parkinglotspringapp.Models.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    @Override
    <S extends ParkingSlot> S save(S entity);

    @Override
    <S extends ParkingSlot> List<S> saveAll(Iterable<S> entities);
}
