package LLD.ParkingLot.Strategy.Parking;

import LLD.ParkingLot.Entities.ParkingFloor;
import LLD.ParkingLot.Entities.ParkingSpot;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FarthestFirstStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> farthestSpot = Optional.empty();

        List<ParkingFloor> reverseFloors = new ArrayList<>();
        Collections.reverse(floors);

        for(ParkingFloor floor : floors){
            farthestSpot = floor.findAvailableSpot(vehicle);
        }
        return farthestSpot;
    }
}
