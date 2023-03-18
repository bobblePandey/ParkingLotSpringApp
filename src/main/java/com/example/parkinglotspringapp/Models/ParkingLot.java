package com.example.parkinglotspringapp.Models;

import com.example.parkinglotspringapp.Repositories.EntryGateRepository;
import lombok.*;
import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class ParkingLot extends BaseModel{

    private String name;
    @OneToMany
    @MappedCollection
    private List<ParkingFloor> floors;
    @OneToMany
    @MappedCollection
    private List<EntryGate>  entryGates;
    @OneToMany
    @MappedCollection
    private List<ExitGate>  exitGates;

    public static ParkingLotBuilder getBuilder() {
        return new ParkingLotBuilder();
    }

    public static class ParkingLotBuilder {

        private String name;
        private int numParkingFloors;

        private int slots;
        private int numEntryGates;
        private int numExitGates;

        public ParkingLotBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder setNumParkingFloors(int numParkingFloors) {
            this.numParkingFloors = numParkingFloors;
            return this;
        }

        public ParkingLotBuilder setNumEntryGates(int numEntryGates) {
            this.numEntryGates = numEntryGates;
            return this;
        }

        public ParkingLotBuilder setNumExitGates(int numExitGates) {
            this.numExitGates = numExitGates;
            return this;
        }

        public ParkingLotBuilder setSlotsPerFloor(int numSlots) {
            this.slots = numSlots;
            return this;
        }

        private ParkingFloor createFloor(int floorNumber, int slotCount) {

            //TODO : Make Slots assignment variable(as per defined enum VehicleType)
            List<ParkingSlot> slotList = new ArrayList<>(slotCount);
            for(int i = 0; i < slotCount; i++) {
                slotList.add(new ParkingSlot( (char)( floorNumber + 'A') + "_" + Integer.toString(i), VehicleType.VEHICLE_LMV, ParkingSlotStatus.SLOT_EMPTY));
            }
            return new ParkingFloor(floorNumber, slotList);
        }

        private boolean validate() {
            if(this.numEntryGates < 1) {
                return false;
            }
            if( this.numExitGates < 1) {
                return false;
            }
            if( this.numParkingFloors < 1) {
                return false;
            }
            if( this.slots < 1 ) {
                return false;
            }
            return true;
        }

        public ParkingLot build() throws Exception{
            if( !validate() ) {
                throw new Exception("");
            }

            List<ParkingFloor> floorList = new ArrayList<>();
            for(int i = 0; i < numParkingFloors; i++) {
                floorList.add(createFloor(i, slots));
            }

            List<EntryGate> entryGates = new ArrayList<>();
            for(int i = 0; i < numEntryGates; i++) {
                entryGates.add(new EntryGate());
            }

            List<ExitGate> exitGates = new ArrayList<>();
            for(int i = 0; i < numEntryGates; i++) {
                exitGates.add(new ExitGate());
            }

            return new ParkingLot(this.name, floorList, entryGates, exitGates);
        }

    }
}
