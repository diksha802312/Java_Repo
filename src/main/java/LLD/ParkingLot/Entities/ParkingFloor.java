package LLD.ParkingLot.Entities;

import LLD.ParkingLot.Vehicle.Vehicle;
import LLD.ParkingLot.Vehicle.VehicleSize;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private int floorNumber;
    private Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Map<String, ParkingSpot> getSpots() {
        return spots;
    }

    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(), spot);
    }

    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        Optional<ParkingSpot> freeSpots =  spots.values().stream().
                filter(parkingSpot -> !parkingSpot.isOccupied() && parkingSpot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotSize)).findFirst();
        return freeSpots;
    }

    public void displayAvalability(){
        System.out.printf("Available spots on floor %d\n", floorNumber);
        Map<VehicleSize, Long> availableCounts = spots.values().stream().filter(ParkingSpot::isAvailable)
                .collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));

        for(VehicleSize size: VehicleSize.values()){
            System.out.printf("%s spots %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }
}
