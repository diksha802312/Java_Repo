package LLD.ParkingLot.Strategy.Parking;

import LLD.ParkingLot.Entities.ParkingFloor;
import LLD.ParkingLot.Entities.ParkingSpot;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class BestFitStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> bestFitSpot = Optional.empty();

        for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spotOnThisFloor = Optional.empty();

            if(bestFitSpot.isEmpty()){
                spotOnThisFloor = floor.findAvailableSpot(vehicle);
                bestFitSpot = spotOnThisFloor;
            }
            else{
                if(spotOnThisFloor.get().getSpotSize().ordinal() < bestFitSpot.get().getSpotSize().ordinal()){
                    bestFitSpot = spotOnThisFloor;
                }
            }
        }
        return bestFitSpot;
    }

}
