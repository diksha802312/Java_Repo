package LLD.ParkingLot.Strategy.Parking;

import LLD.ParkingLot.Entities.ParkingFloor;
import LLD.ParkingLot.Entities.ParkingSpot;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestFirstStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> nearestSpot = Optional.empty();

        for(ParkingFloor floor : floors){
            nearestSpot = floor.findAvailableSpot(vehicle);
            if(nearestSpot.isPresent()){
                return nearestSpot;
            }
        }
        return nearestSpot;
    }
}
