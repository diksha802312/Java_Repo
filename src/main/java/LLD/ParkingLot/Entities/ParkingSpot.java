package LLD.ParkingLot.Entities;

import LLD.ParkingLot.Vehicle.Vehicle;
import LLD.ParkingLot.Vehicle.VehicleSize;

public class ParkingSpot {
    private String spotId;
    private VehicleSize spotSize;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleSize spotSize){
        this.spotId = spotId;
        this.spotSize = spotSize;
        isOccupied = false;
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void parkVehicle(Vehicle vehicle){
        isOccupied = true;
        parkedVehicle = vehicle;
    }

    public void unparkVehicle(Vehicle vehicke){
        isOccupied = false;
        parkedVehicle = null;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if (isOccupied) return false;

        switch(vehicle.getVehicleSize()){
            case SMALL:
                return spotSize == VehicleSize.SMALL;
            case MEDIUM:
                return spotSize == VehicleSize.MEDIUM || spotSize == VehicleSize.LARGE;
            case LARGE:
                return spotSize == VehicleSize.LARGE;
            default : return false;

        }
    }
}
