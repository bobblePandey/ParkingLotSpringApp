package com.example.parkinglotspringapp.Repositories;

import com.example.parkinglotspringapp.Models.ExitGate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExitGateRepository extends JpaRepository<ExitGate, Long> {

    @Override
    <S extends ExitGate> S save(S entity);

}
