package LLD.ParkingLot.Strategy.Parking;

import LLD.ParkingLot.Entities.ParkingFloor;
import LLD.ParkingLot.Entities.ParkingSpot;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {

    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
