package com.example.parkinglotspringapp.Repositories;

import com.example.parkinglotspringapp.Models.EntryGate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryGateRepository extends JpaRepository<EntryGate, Long> {

    @Override
    <S extends EntryGate> S save(S entity);

}
