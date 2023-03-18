package com.example.parkinglotspringapp.Services;

import com.example.parkinglotspringapp.Models.ExitGate;
import com.example.parkinglotspringapp.Models.ParkingFloor;
import com.example.parkinglotspringapp.Models.ParkingLot;
import com.example.parkinglotspringapp.Models.ParkingSlot;
import com.example.parkinglotspringapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    ParkingLotRepository parkingLotRepository;
    ParkingFloorRepository parkingFloorRepository;
    EntryGateRepository entryGateRepository;
    ExitGateRepository exitGateRepository;
    ParkingSlotRepository parkingSlotRepository;

    ParkingLot parkingLot;

    @Autowired
    ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository,
                      EntryGateRepository entryGateRepository, ExitGateRepository exitGateRepository,
                      ParkingSlotRepository parkingSlotRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.entryGateRepository = entryGateRepository;
        this.exitGateRepository = exitGateRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public void createParkingLot() {
        try {
            parkingLot = ParkingLot.getBuilder().setName("Ayodhya Cantt Railway Station").setNumParkingFloors(3)
                    .setNumEntryGates(3).setNumExitGates(4).setSlotsPerFloor(50).build();
            List<ParkingFloor> floors = parkingLot.getFloors();
            for(ParkingFloor floor : floors) {
                List<ParkingSlot> slots = floor.getSlots();
                parkingSlotRepository.saveAll(slots);
            }
            parkingFloorRepository.saveAll(floors);
            entryGateRepository.saveAll(parkingLot.getEntryGates());
            exitGateRepository.saveAll(parkingLot.getExitGates());
            parkingLotRepository.save(parkingLot);
        }
        catch (Exception e) {
            //TODO: Create custom Exception
            e.printStackTrace();
        }
    }

}
