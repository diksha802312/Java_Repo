package LLD.ParkingLot;

import LLD.ParkingLot.Entities.ParkingFloor;
import LLD.ParkingLot.Entities.ParkingSpot;
import LLD.ParkingLot.Entities.ParkingTicket;
import LLD.ParkingLot.Strategy.Fee.FeeStrategy;
import LLD.ParkingLot.Strategy.Fee.FlatRateFeeStrategy;
import LLD.ParkingLot.Strategy.Parking.NearestFirstStrategy;
import LLD.ParkingLot.Strategy.Parking.ParkingStrategy;
import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private ParkingStrategy parkingStrategy;
    private List<ParkingFloor> floors = new ArrayList<>();
    private Map<String, ParkingTicket> activeTickets;
    private FeeStrategy feeStrategy;
    private static ParkingLot parkingLot;

    private ParkingLot(){
        this.parkingStrategy = new NearestFirstStrategy();
        this.feeStrategy = new FlatRateFeeStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
    }
    public static synchronized ParkingLot getInstance(){
        if(parkingLot==null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addFloor(ParkingFloor parkingFloor){
        floors.add(parkingFloor);
    }
    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);
        ParkingTicket ticket = null;

        if(availableSpot.isEmpty()){
            System.out.printf("No parking spots available for %s\n", vehicle.getLicenseNumber());
            return Optional.empty();
        }
        else{
            availableSpot.get().parkVehicle(vehicle);
            ticket = new ParkingTicket(availableSpot.get(), vehicle);
            System.out.printf("%s vehicle parked at %s spot\n", vehicle.getLicenseNumber(), availableSpot.get().getSpotId());
            activeTickets.put(vehicle.getLicenseNumber(), ticket);
        }
        return Optional.of(ticket);
    }

    public Double unParkVehicle(Vehicle vehicle){
        ParkingTicket ticket = activeTickets.get(vehicle.getLicenseNumber());

        if(Objects.isNull(ticket)){
            System.out.printf("ticket not found for %s vehicle", vehicle.getLicenseNumber());
        }
        else{
            ParkingSpot spot = ticket.getSpot();
            spot.unparkVehicle(vehicle);
            ticket.setExitTimeStamp(System.currentTimeMillis());
            activeTickets.remove(vehicle.getLicenseNumber());
            Double fee = feeStrategy.calculateFee(ticket);
            System.out.printf("fee %.2f for vehicle %s\n", fee, vehicle.getLicenseNumber());
            return fee;
        }
        return null;
    }
}
